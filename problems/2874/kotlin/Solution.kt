class Solution {
    fun maximumTripletValue(nums: IntArray) =
        nums.fold(Triple(0L, 0, 0)) { (max, ab, a), num ->
            Triple(maxOf(max, ab.toLong() * num), maxOf(ab, a - num), maxOf(a, num))
        }.first
}
