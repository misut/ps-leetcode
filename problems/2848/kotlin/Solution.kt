class Solution {
    fun numberOfPoints(nums: List<List<Int>>): Int {
        val covered = BooleanArray(101) { false }
        nums.forEach { (start, end) ->
            (start..end).forEach { covered[it] = true }
        }
        return covered.count { it }
    }
}
