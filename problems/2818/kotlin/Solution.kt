import java.util.*
import kotlin.math.min

class Solution {
    companion object {
        const val mod = 1000000007
    }

    fun pow(x: Int, n: Int): Int {
        if (n == 0)
            return 1
        var res = (pow(x, n / 2) % mod).toLong()
        res = (res * res) % mod
        return (if (n % 2 == 1) (res * x) % mod else res).toInt()
    }

    fun maximumScore(nums: List<Int>, k: Int): Int {
        val len = nums.size
        val upper = nums.max()!!

        val prime = Array(100001) { true }
        val primeScores = Array(100001) { 0 }
        prime[0] = false
        prime[1] = false
        for (i in (2..upper)) {
            if (prime[i]) {
                for (j in (i..upper step i)) {
                    primeScores[j] += 1
                    prime[j] = false
                }
            }
        }

        val prevGreaterOrEqualElement = Array(len) { -1 }
        val nextGreaterElement = Array(len) { len }
        Stack<Int>().let {
            for (i in (0..len - 1).reversed()) {
                while (!it.empty() && primeScores[nums[i]] >= primeScores[nums[it.peek()]])
                    it.pop()
                nextGreaterElement[i] = if (it.empty()) len else it.peek()
                it.push(i)
            }

            it.clear()
            for (i in (0..len - 1)) {
                while (!it.empty() && primeScores[nums[i]] > primeScores[nums[it.peek()]])
                    it.pop()
                prevGreaterOrEqualElement[i] = if (it.empty()) -1 else it.peek()
                it.push(i)
            }
        }

        var res = 1L
        var tmp = k
        nums.mapIndexed { idx, num -> num to idx }.sortedWith(Comparator { o1, o2 -> o2.first - o1.first }).forEach { (num, idx) ->
            val ops = min(tmp, (idx - prevGreaterOrEqualElement[idx]) * (nextGreaterElement[idx] - idx))
            res = (res * pow(num, ops)) % mod
            tmp -= ops
            if (tmp == 0)
                return res.toInt()
        }
        return res.toInt()
    }
}