class Solution {
    fun minimumPossibleSum(n: Int, target: Int): Long {
        return if (target <= 2 || target > n * 2) {
            (n.toLong() * (n + 1) / 2)
        } else {
            (n.toLong() * (n + 1) / 2 + (n - target / 2).toLong() * (target - target / 2 - 1))
        }
    }
}
