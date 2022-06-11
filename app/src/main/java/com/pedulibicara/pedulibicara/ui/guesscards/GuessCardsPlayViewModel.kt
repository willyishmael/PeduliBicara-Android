package com.pedulibicara.pedulibicara.ui.guesscards

import androidx.lifecycle.ViewModel
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.data.remote.response.ModelResponse
import com.pedulibicara.pedulibicara.data.repository.DataRepository
import com.pedulibicara.pedulibicara.data.repository.ModelRepository
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import kotlin.random.Random

class GuessCardsPlayViewModel : ViewModel() {
    private val dataRepository = DataRepository()
    private val modelRepository = ModelRepository()

    private lateinit var questions : List<ModuleItem>
    private var currentQuestionPosition = 0
    private var score = 0

    /**
     * Get all ModuleItems from local data
     * @return List<ModuleItem>
     */
    private fun getAllModuleItems() = dataRepository.getAllModuleItem()

    /**
     * Generate random list of ModuleItem
     * @return List<ModuleItem>
     */
    private fun getRandomModuleItems() : List<ModuleItem> {
        val list = getAllModuleItems()
        val listCount = list.count()
        val randomIndex = List(QUESTION_COUNT) { Random.nextInt(0, listCount)}
        val randomList = mutableListOf<ModuleItem>()

        for (i in 0 until QUESTION_COUNT) {
            randomList.add(list[randomIndex[i]])
        }

        return randomList
    }

    /**
     * Generate questions
     *
     */
    fun generateQuestions() {
        questions = getRandomModuleItems()
    }

    /**
     * Get a question(ModuleItem) based on current position
     * @return ModuleItem
     */
    fun getQuestion() : ModuleItem {
        return questions[currentQuestionPosition]
    }

    /**
     * Next question
     *
     */
    fun nextQuestion() {
        if (currentQuestionPosition < QUESTION_COUNT) {
            currentQuestionPosition += 1
        }
    }

    /**
     * Upload voice file to machine learning model
     * @param file Part: recorded voice
     * @return Flow<Result<ModelResponse>>
     */
    suspend fun predictVoice(
        file: MultipartBody.Part
    ): Flow<Result<ModelResponse>> = modelRepository.predict(file)

    /**
     * Check result from voice predict model,
     * will return true if equals to current ModuleItem name
     * @param result String
     * @return Boolean
     */
    fun checkAnswer(result: String): Boolean {
        val rightAnswer = questions[currentQuestionPosition].name
        return if (result == rightAnswer) {
            score += 1
            true
        } else false
    }

    companion object {
        const val QUESTION_COUNT = 5
    }
}