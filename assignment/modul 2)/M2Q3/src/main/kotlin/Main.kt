import java.util.Scanner

//Kotlin Program to Add Two Integers

fun main(args: Array<String>)
{
    var sc=Scanner(System.`in`)

    println("Enter first number:")
    var first:Int=sc.nextInt()

    println("Enter second number:")
    var second:Int=sc.nextInt()

    var sum=first+second

    println("Sum is $sum")
}