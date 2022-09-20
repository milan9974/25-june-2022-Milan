import java.util.Scanner

//WAP to find max value using function as express


fun maxvalue(num1:Int, num2:Int)
{

    if (num1>num2)
    {
        println("$num1 is gretter than $num2")
    }
    else if (num1==num2)
    {
        println("$num1 and $num2 is equal")
    }
    else
    {
        println("$num2 is gretter than $num1")
    }
}

fun main() {

    var sc=Scanner(System.`in`)

    println("Enter number 1:")
    var num1=sc.nextInt()

    println("Enter number 2:")
    var num2=sc.nextInt()

    maxvalue(num1,num2)
}