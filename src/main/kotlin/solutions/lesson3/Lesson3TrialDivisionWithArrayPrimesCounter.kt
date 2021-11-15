package solutions.lesson3

import api.Task

// сложность алгоритма
// N * √N/ln√N
class Lesson3TrialDivisionWithArrayPrimesCounter : Task {
    override fun run(data: List<String>): String {
        if (data.size != 1) {
            throw IllegalArgumentException()
        }

        return countPrimes(data[0].toInt()).toString()
    }


    private fun countPrimes(n: Int): Int {
        if (n <= 1) {
            return 0
        }
        // в массиве хранятся предыдущие простые числа, так как в качестве делителя -- простое число
        val primes = mutableListOf<Int>()
        primes.add(2)

        for (p in 3..n step 2) { // игнорируем четные
            if (isPrime(primes, p)) {
                primes.add(p)
            }
        }

        return primes.size
    }

    private fun isPrime(primes: MutableList<Int>, p: Int): Boolean {
        val sqrtOfP = Math.sqrt(p.toDouble()).toInt()
        var i = 0
        while (primes[i++] <= sqrtOfP) { // пробегаемся по простым числам
            if (p % primes[i] == 0) {
                return false
            }
        }

        return true
    }
}