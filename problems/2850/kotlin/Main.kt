fun main() {
    val testCases = listOf(
        arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(1, 2, 1)) to 3,
        arrayOf(intArrayOf(1, 3, 0), intArrayOf(1, 0, 0), intArrayOf(1, 0, 3)) to 4,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().minimumMoves(testCase)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
