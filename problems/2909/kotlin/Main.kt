fun main() {
    val testCases = listOf(
        listOf(8, 6, 1, 5, 3).toIntArray() to 9,
        listOf(5, 4, 8, 7, 10, 2).toIntArray() to 13,
        listOf(6, 5, 4, 3, 4, 5).toIntArray() to -1,
        listOf(1, 1, 2, 1).toIntArray() to 4,
        listOf(5, 4, 8, 7, 10, 2).toIntArray() to 13,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().minimumSum(testCase)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
