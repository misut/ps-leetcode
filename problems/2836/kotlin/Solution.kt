class Solution {
    fun getMaxFunctionValue(receiver: List<Int>, k: Long): Long {
        val m = 35
        val n = receiver.size

        val dp = Array(m) { Array(n) { LongArray(2) } }
        for (j in 0 until n) {
            dp[0][j][0] = receiver[j].toLong()
            dp[0][j][1] = receiver[j].toLong()
        }
        for (i in 1 until m) {
            for (j in 0 until n) {
                val x = dp[i - 1][j][0].toInt()
                dp[i][j] = longArrayOf(dp[i - 1][x][0], dp[i - 1][j][1] + dp[i - 1][x][1])
            }
        }
        var res = 0L
        for (i in 0 until n) {
            var r = i.toLong()
            var now = i
            for (j in 0 until m) {
                if (((1L shl j) and k) == 0L) continue
                r += dp[j][now][1]
                now = dp[j][now][0].toInt()
            }
            res = maxOf(r, res)
        }
        return res
    }
}
