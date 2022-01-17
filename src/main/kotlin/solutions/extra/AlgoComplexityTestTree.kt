var callCount: Int = 0

fun tree(n: Int): Int {
    callCount += 1
    return if (n == 0) {
        1
    } else {
        2 * tree(n - 1)
    }
}

fun main() {
    tree(5)
    println(callCount)
}