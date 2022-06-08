package com.pedulibicara.pedulibicara.ui.guesscards

import androidx.lifecycle.ViewModel
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.data.repository.DataRepository
import kotlin.random.Random

class GuessCardsPlayViewModel : ViewModel() {
    private val repository = DataRepository()
    private fun getAllModuleItems() = repository.getAllModuleItem()
    private fun getModuleItems(category: String) = repository.getModuleItems(category)

    private lateinit var questions : List<ModuleItem>
    private var currentQuestionPosition = 0
    fun getCurrentQuestionPosition() = currentQuestionPosition

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

    fun generateQuestions() {
        questions = getRandomModuleItems()
    }

    fun getQuestion() : ModuleItem {
        return questions[currentQuestionPosition]
    }

    fun nextQuestion() {
        if (currentQuestionPosition < QUESTION_COUNT) {
            currentQuestionPosition += 1
        }
    }

    companion object {
        const val QUESTION_COUNT = 5
    }
}