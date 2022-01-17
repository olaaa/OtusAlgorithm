package solutions.extra

import kotlin.math.pow

var nextCount = 0
fun next(n: Int) {
    if (n <= 0) {
        return
    }
    nextCount += 1

//    println(n)
    for (i in 0 until n) {
//        println("n = $n i = $i")
        next(n - 1)
    }
}

fun factorialUsingRecursion(n: Int): Int {
    return if (n == 0) {
        1
    } else n * factorialUsingRecursion(n - 1)
}

fun main() {
    val n = 10

    var result = 0
    var previous = n
    for (i in 1 until n) {
        result += previous
        previous *= (n - i)
    }

    println(result )

    println(factorialUsingRecursion(n))
    println(n.toDouble().pow(n))

    next(n)
    println(nextCount)
}