class Solution {
    fun sumIndicesWithKSetBits(nums: List<Int>, k: Int): Int = nums.filterIndexed { idx, _ -> idx.countSetBits() == k }.sum()
}

fun Int.countSetBits(): Int = if (this == 0) 0 else (this and 1) + (this shr 1).countSetBits()
