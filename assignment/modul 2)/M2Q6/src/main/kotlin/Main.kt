import java.util.Scanner

//Kotlin Program to Check Whether a Number is Even or Odd

fun main(args: Array<String>)
{
    var sc=Scanner(System.`in`)

    println("Enter number:")
    var number:Int=sc.nextInt()

    if(number%2==0)
    {
        println("EVEN")
    }
    else
    {
        println("ODD")
    }
}