const val MAX = 50

class Solution {
    fun minimumSum(nums: IntArray): Int {
        val min = nums.min()
        val pivot = nums.indexOf(min)

        var sum = -1
        val stack = mutableListOf<Int>()
        nums.slice(0..<pivot).forEach { num ->
            if (stack.size == 0) {
                stack.add(num)
            } else if (stack.size == 2 && stack.first() > num) {
                stack.clear()
                stack.add(num)
            } else if (stack.last() > num && (stack.size == 1 || stack.first() < num)) {
                stack.removeLast()
                stack.add(num)
            } else if (stack.size == 1 && stack.last() < num) {
                stack.add(num)
            }

            if (stack.size == 2 && (sum == -1 || sum > stack.sum())) {
                sum = stack.sum()
            }
        }

        stack.clear()
        nums.slice((pivot + 1)..<nums.size).reversed().forEach { num ->
            if (stack.size == 0) {
                stack.add(num)
            } else if (stack.size == 2 && stack.first() > num) {
                stack.clear()
                stack.add(num)
            } else if (stack.last() > num && (stack.size == 1 || stack.first() < num)) {
                stack.removeLast()
                stack.add(num)
            } else if (stack.size == 1 && stack.last() < num) {
                stack.add(num)
            }

            if (stack.size == 2 && (sum == -1 || sum > stack.sum())) {
                sum = stack.sum()
            }
        }

        if (sum == -1) {
            return -1
        }
        return sum + min
    }
}
