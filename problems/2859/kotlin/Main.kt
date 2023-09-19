fun main() {
    val testCases = listOf(
        (listOf(5, 10, 1, 5, 2) to 1) to 13,
        (listOf(4, 3, 2, 1) to 2) to 1,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().sumIndicesWithKSetBits(testCase.first, testCase.second)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
