class Solution {
    fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
        var ans = 0L
        var cur = 0
        var cnt = mutableMapOf(0 to 1)
        nums.forEach {
            cur += if (it % modulo == k) 1 else 0
            cur %= modulo

            ans += cnt.getOrDefault((cur - k + modulo) % modulo, 0)
            cnt.put(cur, cnt.getOrDefault(cur, 0) + 1)
        }
        return ans
    }
}
