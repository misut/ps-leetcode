fun main() {
    val testCases = listOf(
        listOf(1, 1)  to 2,
        listOf(6, 0, 3, 3, 6, 7, 2, 7)to 3,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().countWays(testCase)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
