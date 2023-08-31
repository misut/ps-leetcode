import java.util.TreeMap

class Solution {
    fun minOperations(nums: List<Int>, target: Int): Int {
        nums.sumOf { it.toLong() }.let {
            if (it < target.toLong()) {
                return -1
            }

            if (it == target.toLong()) {
                return 0
            }
        }

        val sortedNums = TreeMap<Int, Int>()
        nums.forEach { num -> sortedNums.put(num, sortedNums.getOrDefault(num, 0) + 1)}

        val max = nums.max()
        var exp = 0
        var ops = 0
        var pow = 1
        var remaining = target
        while (exp < 31 && pow < max && remaining > 0) {
            if ((remaining shr exp) and 1 == 1) {
                remaining -= pow

                if (sortedNums.containsKey(pow)) {
                    val cnt = sortedNums.remove(pow)
                    if (cnt!! > 1) {
                        sortedNums.put(pow, cnt - 1)
                    }
                } else {
                    var num = sortedNums.ceilingKey(pow)

                    val cnt = sortedNums.remove(num)
                    if (cnt!! > 1) {
                        sortedNums.put(num, cnt - 1)
                    }

                    while (num != pow) {
                        ops += 1
                        num = num shr 1
                        sortedNums.put(num, sortedNums.getOrDefault(num, 0) + 1)
                    }
                }
            }

            (0..exp).forEach {
                val num = 1 shl it
                if (sortedNums.getOrDefault(num, 0) > 1) {
                    val cnt = sortedNums.get(num)!!
                    sortedNums.put(num shl 1, sortedNums.getOrDefault(num shl 1, 0) + (cnt shr 1))
                    sortedNums.put(num, 1)
                }
            }

            exp += 1
            pow = pow shl 1
        }

        return ops
    }
}
