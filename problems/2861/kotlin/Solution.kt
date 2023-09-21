class Solution {
    fun maxNumberOfAlloys(
        n: Int,
        k: Int,
        budget: Int,
        composition: List<List<Int>>,
        stock: List<Int>,
        cost: List<Int>
    ): Int =
        composition.maxOf { it.findCount(budget, stock, cost) }
}

fun List<Int>.isAvailable(count: Int, budget: Int, stock: List<Int>, cost: List<Int>): Boolean =
    mapIndexed { idx, num -> maxOf(0, (num.toLong() * count - stock[idx])) * cost[idx] }.sum() <= budget

fun List<Int>.findCount(budget: Int, stock: List<Int>, cost: List<Int>): Int {
    var lo = 0
    var hi = Int.MAX_VALUE
    while (lo <= hi) {
        val mi = (lo + hi) / 2
        if (isAvailable(mi, budget, stock, cost)) {
            lo = mi + 1
        } else {
            hi = mi - 1
        }
    }
    return lo - 1
}
