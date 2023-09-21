class Solution {
    fun maximumTripletValue(nums: IntArray): Long {
        var max = 0L
        nums.toList().forEachCombination(3) { (i, j, k) ->
            max = maxOf((i.toLong() - j) * k, max)
        }
        return max
    }
}

fun <T> List<T>.forEachCombination(r: Int, action: (List<T>) -> Unit): Unit {
    if (r == 0) {
        action(emptyList())
    } else {
        forEachIndexed { i, v ->
            slice(i + 1..<size)
                .forEachCombination(r - 1) { action(listOf(v) + it) }
        }
    }
}
