import java.util.TreeSet
import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun minAbsoluteDifference(nums: List<Int>, x: Int): Int {
        var minDiff = Int.MAX_VALUE
        val treeSet = sortedSetOf<Int>()
        (x..nums.size - 1).forEach { i ->
            treeSet.add(nums[i - x])
            treeSet.ceiling(nums[i])?.also { hi ->
                minDiff = min(minDiff, abs(nums[i] - hi))
            }
            treeSet.floor(nums[i])?.also { lo ->
                minDiff = min(minDiff, abs(nums[i] - lo))
            }
        }
        return minDiff
    }
}