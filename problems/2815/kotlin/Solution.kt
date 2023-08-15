import kotlin.math.max

class Solution {
    fun maxSum(nums: IntArray): Int {
        var res = -1
        nums.toList().forEachCombination(2) { comb ->
            val maxDigits = comb.map { it.maxDigit() }
            if(maxDigits.all { maxDigits.first() == it}) res = max(res, comb.sum())
        }
        return res
    }
}

fun Int.maxDigit(): Int = if (this < 10) this else max(this % 10, (this / 10).maxDigit())

fun <T> List<T>.forEachCombination(r: Int, action: (List<T>) -> Unit): Unit {
    if (r == 0) {
        action(emptyList())
    } else {
        forEachIndexed { i, v -> slice(i + 1..size - 1)
            .forEachCombination(r - 1) { action(listOf(v) + it) } }
    }
}