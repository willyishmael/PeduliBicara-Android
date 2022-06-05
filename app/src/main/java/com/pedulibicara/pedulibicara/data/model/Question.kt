package com.pedulibicara.pedulibicara.data.model

data class Question(
    var answer: ModuleItem,
    var option1: ModuleItem,
    var option2: ModuleItem,
    var option3: ModuleItem,
    var indexPattern: List<Int>
)
