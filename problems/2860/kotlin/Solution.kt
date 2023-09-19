class Solution {
    fun countWays(nums: List<Int>): Int {
        var selected = 0
        var ways = 0
        nums.toCounterMap().forEach { (num, count) ->
            if (num > selected && num < selected + count) {
                ways += 1
            }
            selected += count
        }
        return ways + 1
    }
}

fun List<Int>.toCounterMap(): Map<Int, Int> {
    val map = mutableMapOf<Int, Int>()
    forEach { map[it] = map.getOrDefault(it, 0) + 1 }
    return map.toSortedMap()
}
