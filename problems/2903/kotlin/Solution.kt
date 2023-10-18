class Solution {
    fun findIndices(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {
        nums.forEachIndexed { i, ni ->
            if (i + indexDifference < nums.size) {
                nums.slice(i + indexDifference..<nums.size).forEachIndexed { j, nj ->
                    if (abs(ni - nj) >= valueDifference) {
                        return listOf(i, i + j + indexDifference).toIntArray()
                    }
                }
            }
        }
        return listOf(-1, -1).toIntArray()
    }
}

fun abs(n: Int): Int = if (n < 0) -n else n
