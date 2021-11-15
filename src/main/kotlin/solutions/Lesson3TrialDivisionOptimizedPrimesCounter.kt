package solutions

import api.Task

class Lesson3TrialDivisionOptimizedPrimesCounter : Task {
    override fun run(data: List<String>): String {
        if (data.size != 1) {
            throw IllegalArgumentException()
        }

        var countOfPrimes = 0
        for (i in 2..data[0].toInt()) {
            if (isPrime(i)) {
                countOfPrimes++
            }
        }

        return countOfPrimes.toString()
    }

    // сложность алгоритма: N * корень квадратный из N
    private fun isPrime(p: Int): Boolean {
        if (p == 2) return true
        if (p % 2 == 0) return false

        val sqrtOfP = Math.sqrt(p.toDouble()).toInt()
        for (i in 3..sqrtOfP step 2) {
            if (p % i == 0) {
                return false
            }
        }

        return true
    }
}