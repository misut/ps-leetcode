fun main() {
    val testCases = listOf(
        (1 to 100) to 9,
        (1200 to 1230) to 4,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().countSymmetricIntegers(testCase.first, testCase.second)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
