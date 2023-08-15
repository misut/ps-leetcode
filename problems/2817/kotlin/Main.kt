fun main() {
    val testCases = listOf(
        (listOf(4, 3, 2, 4) to 2) to 0,
        (listOf(5, 3, 2, 10, 15) to 1) to 1,
        (listOf(1, 2, 3, 4) to 3) to 3
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().minAbsoluteDifference(testCase.first, testCase.second)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}