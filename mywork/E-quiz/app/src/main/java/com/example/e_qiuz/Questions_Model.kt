package com.example.e_qiuz

data class Questions_Model(var id:Int,
                           var question: String,
                           var img:Int,
                           var optionOne:String,
                           var optionTwo:String,
                           var optionThree:String,
                           var optionFour:String,
                           var correctAns:Int
                     )
