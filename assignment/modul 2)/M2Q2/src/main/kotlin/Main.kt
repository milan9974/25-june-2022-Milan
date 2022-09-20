import java.util.Scanner


//Kotlin Program to Print an Integer (Entered by the User)

fun main(args: Array<String>)
{
    var sc=Scanner(System.`in`)

    println("Enter number:")
    var number:Int=sc.nextInt()

    println("Number is $number")
}