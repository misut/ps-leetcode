fun main() {
    val testCases = listOf(
        listOf(listOf(3, 6), listOf(1, 5), listOf(4, 7)) to 7,
        listOf(listOf(1, 3), listOf(5, 8)) to 7,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().numberOfPoints(testCase)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
