fun main() {
    val testCases = listOf(
        (listOf(8, 3, 9, 3, 8) to 2) to 81,
        (listOf(19, 12, 14, 6, 10, 18) to 3) to 4788
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().maximumScore(testCase.first, testCase.second)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}