package solutions.lesson3

import api.Task

//  сложность алгоритма экспоненциальная 2^N, сложность по памяти линейная
class RecursiveFibonacci : Task {
    override fun run(data: List<String>): String {
        if (data.size != 1) {
            throw IllegalArgumentException()
        }

        return fibo(data[0].toInt()).toString()
    }

    private fun fibo(i: Int): Int {
        if (i == 0 || i == 1) {
            return i
        }

        return fibo(i - 1) + fibo(i - 2)
    }
}