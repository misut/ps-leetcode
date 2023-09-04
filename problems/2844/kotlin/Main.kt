fun main() {
    val testCases = listOf(
        "2245047" to 2,
        "2908305" to 3,
        "10" to 1,
        "5" to 1,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().minimumOperations(testCase)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
