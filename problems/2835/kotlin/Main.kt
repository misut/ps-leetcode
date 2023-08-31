fun main() {
    val testCases = listOf(
        (listOf(1, 2, 8) to 7) to 1,
        (listOf(1, 32, 1, 2) to 12) to 2,
        (listOf(1, 32, 1) to 35) to -1,
        (listOf(2, 1, 8, 64, 64) to 6) to 1,
        (listOf(1) to 1) to 0,
        (listOf(64, 32, 2, 8) to 5) to 2,
        (listOf(16, 16, 4) to 3) to 2,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().minOperations(testCase.first, testCase.second)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
