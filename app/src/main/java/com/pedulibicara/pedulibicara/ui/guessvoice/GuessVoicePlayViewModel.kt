package com.pedulibicara.pedulibicara.ui.guessvoice

import androidx.lifecycle.ViewModel
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.data.model.Question
import com.pedulibicara.pedulibicara.data.repository.DataRepository
import kotlin.random.Random

class GuessVoicePlayViewModel : ViewModel() {

    private val repository = DataRepository()
    private fun getAllModuleItem() = repository.getAllModuleItem()
    private fun getModuleItems(category: String) = repository.getModuleItems(category)

    private fun getRandomModuleItem(count: Int) : List<ModuleItem> {
        val list = getAllModuleItem()
        val listCount = list.count()
        val randomIndex = List(count) {Random.nextInt(0, listCount)}
        val randomList = mutableListOf<ModuleItem>()

        for (i in 0 until count) {
            randomList.add(list[randomIndex[i]])
        }

        return randomList
    }

    private fun getFalseOption(category: String, excludeThisItem: ModuleItem) : List<ModuleItem> {
        val list = getModuleItems(category)
        val listCount = list.count()
        val listModuleItem = mutableListOf<ModuleItem>()

        for (index in 0 until FALSE_OPTIONS_COUNT) {
            do {
                val randomItem = list[Random.nextInt(0, listCount)]
                listModuleItem.add(index, randomItem)
            } while (randomItem.name == excludeThisItem.name)
        }

        return listModuleItem
    }

    fun getQuestions(count: Int) : List<Question> {
        val listRandomModuleItem = getRandomModuleItem(count)
        val listQuestion = mutableListOf<Question>()

        for (i in 0 until count) {
            val moduleItem = listRandomModuleItem[i]
            val category = moduleItem.category
            val falseOptions = getFalseOption(category, moduleItem)
            val question = Question(
                answer = moduleItem,
                option1 = falseOptions[0],
                option2 = falseOptions[1],
                option3 = falseOptions[2]
            )
            listQuestion.add(question)
        }

        return listQuestion
    }

    companion object {
        private const val FALSE_OPTIONS_COUNT = 3
    }


}