import java.util.Scanner


//Kotlin Program to Compute Quotient and Remainder

fun main(args:Array<String>)
{
    var sc=Scanner(System.`in`)

    println("Enter number:")
    var dividant:Int=sc.nextInt()

    println("Enter number:")
    var divisor:Int=sc.nextInt()

    println("Quotient= ${dividant/divisor}")
    println("Remaider= ${dividant%divisor}")
}