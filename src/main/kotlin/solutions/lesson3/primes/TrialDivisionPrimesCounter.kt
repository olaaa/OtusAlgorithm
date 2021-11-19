package solutions.lesson3.primes

import api.Task

class TrialDivisionPrimesCounter : Task {
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

    private fun isPrime(p: Int): Boolean {
        for (i in 2 until p) {
            if (p % i == 0) {
                return false
            }
        }

        return true
    }
}