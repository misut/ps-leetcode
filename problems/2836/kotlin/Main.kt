fun main() {
    val testCases = listOf(
        (listOf(2, 0, 1) to 4L) to 6L,
        (listOf(1, 1, 1, 2, 3) to 3L) to 10L,
        (listOf(0, 0) to 7L) to 1L,
        (listOf(3, 2, 2, 1, 0) to 2L) to 7L,
        (listOf(0, 3, 3, 0) to 10L) to 5L,
        (((1..99999).toList()+ listOf(0)) to 10000000000) to 0L,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().getMaxFunctionValue(testCase.first, testCase.second)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
