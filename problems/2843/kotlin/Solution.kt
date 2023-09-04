import kotlin.math.*

class Solution {
    fun countSymmetricIntegers(low: Int, high: Int): Int =
        (low..high).count { it.isSymmetric() }
}

fun Int.sumOfDigits(): Int {
    if (this == 0) {
        return 0
    }
    return this % 10 + (this / 10).sumOfDigits()
}

fun Int.isSymmetric(): Boolean {
    val digits = log10(this.toDouble()).toInt() + 1
    if (digits % 2 == 1) {
        return false
    }

    val divider = 10.0.pow(digits / 2).toInt()
    val upperHalf = this / divider
    val lowerHalf = this % divider
    return upperHalf.sumOfDigits() == lowerHalf.sumOfDigits()
}
