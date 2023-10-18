class Solution {
    fun findIndices(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {
        var (minIdx, maxIdx) = 0 to 0
        (indexDifference..<nums.size).forEach { i ->
            val curIdx = i - indexDifference
            minIdx = if (nums[curIdx] < nums[minIdx]) curIdx else minIdx
            maxIdx = if (nums[curIdx] > nums[maxIdx]) curIdx else maxIdx

            if (abs(nums[minIdx] - nums[i]) >= valueDifference) {
                return listOf(minIdx, i).toIntArray()
            }
            if (abs(nums[maxIdx] - nums[i]) >= valueDifference) {
                return listOf(maxIdx, i).toIntArray()
            }
        }
        return listOf(-1, -1).toIntArray()
    }
}

fun abs(n: Int): Int = if (n < 0) -n else n
