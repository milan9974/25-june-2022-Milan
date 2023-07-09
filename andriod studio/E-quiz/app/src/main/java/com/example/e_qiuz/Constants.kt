package com.example.e_qiuz

object Constants {

//    const val USER_NAME :String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestions():ArrayList<Questions_Model>{
        val questionList=ArrayList<Questions_Model>()

        var Q1=Questions_Model(
            1,"1. Name the person shown in the picture below.",
            R.drawable.murmu,
            "Indira gandhi",
            "Droupadi Murmu",
            "Mamata Banerjee",
            "Anandiben Patel",
            2
        )
        questionList.add(Q1)

        var Q2=Questions_Model(
            2,"2. Given the below flag is which country's?",
            R.drawable.australia,
            "Australia",
            "South africa",
            "New zealand",
            "Canada",
            1
        )
        questionList.add(Q2)

        var Q3=Questions_Model(
            3,"3. What is the name of this religion, which is mainly popular in Asian countries?",
            R.drawable.budh,
            "Sikh",
            "Hinduism",
            "Christian ",
            "Buddhism",
            4
        )
        questionList.add(Q3)

        var Q4=Questions_Model(
            4,"4. What is the approximate value of this mathematical constant?\n",
            R.drawable.pi,
            "1.34",
            "3.14",
            "3.41",
            "1.43",
            2
        )
        questionList.add(Q4)

        var Q5=Questions_Model(
            5,"5. What is the height of statue of unity?",
            R.drawable.sardarpatel,
            "170 meter",
            "180 meter",
            "182 meter",
            "185 meter",
            3
        )
        questionList.add(Q5)

        var Q6=Questions_Model(
            6,"6. How many bones are there in the human body?",
            R.drawable.humanbones,
            "306",
            "300",
            "206",
            "225",
            3
        )
        questionList.add(Q6)

        var Q7=Questions_Model(
            7,"7. Which is the coldest planet in space?",
            R.drawable.uranus,
            "Shukra",
            "Uranus",
            "Budh",
            "Shani",
            2
        )
        questionList.add(Q7)

        var Q8=Questions_Model(
            8,"8. Which of the following represents the minimum age required to become the member of Rajya Sabha?",
            R.drawable.rajyasabha,
            "25 years",
            "35 years",
            "30 years",
            "There is no age limit as such",
            3
        )
        questionList.add(Q8)

        var Q9=Questions_Model(
            9,"9. Largest States of India by Total Area?",
            R.drawable.rajsthan,
            "Rajasthan",
            "Madhya Pradesh",
            "Maharashtra",
            "Andhra Pradesh",
            1
        )
        questionList.add(Q9)

        var Q10=Questions_Model(
            10,"10. How many countries border touch to india?",
            R.drawable.indiamap,
            "5",
            "6",
            "8",
            "7",
            4
        )
        questionList.add(Q10)

        return questionList
    }
}