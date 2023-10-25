class Solution {
    fun minGroupsForValidAssignment(nums: IntArray): Int {
        val counts = nums.toCounterMap().values

        var ans = 0
        var pivot = counts.min() + 1
        while (pivot > 0) {
            for (count in counts) {
                ans += count.minGroups(pivot)
                if (!count.isGroupable(pivot)) {
                    while (!count.isGroupable(pivot)) {
                        pivot -= 1
                    }
                    ans = 0
                    break
                }
            }
            if (ans == 0) {
                continue
            }
            return ans
        }
        return counts.sum()
    }
}

fun Int.isGroupable(pivot: Int) = if (this % pivot == 0) {
    true
} else if (this < (pivot - 1) * (this / pivot + 1)) {
    false
} else {
    true
}

fun Int.minGroups(pivot: Int) =
    minOf(this / (pivot - 1), this / pivot + (this % pivot).let { if (it > 0) 1 else 0 })

fun IntArray.toCounterMap(): Map<Int, Int> = fold(mutableMapOf()) { counter, num ->
    counter[num] = counter.getOrDefault(num, 0) + 1
    counter
}
