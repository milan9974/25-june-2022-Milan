import java.util.Scanner

//Kotlin Program to Find the Frequency of Character in a String

fun main() {

    var sc=Scanner(System.`in`)

    val str:String
    println("Enter a String:")
    str=sc.next()
    str.toLowerCase()

    var cout:Int=0

    for (i in 0..str.length-1)
    {
        if ('m'==str[i])
        {
            cout++
        }
    }

    println(cout)

}