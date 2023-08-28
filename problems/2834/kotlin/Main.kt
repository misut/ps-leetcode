fun main() {
    val testCases = listOf(
        (2 to 3) to 4.toLong(),
        (3 to 3) to 8.toLong(),
        (1 to 1) to 1.toLong(),
        (16 to 6) to 162.toLong(),
        (13 to 50) to 91.toLong(),
        (37 to 46) to 1011.toLong(),
        (63623 to 82276) to 2948940321,
        (100000 to 100000) to 7500000000
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().minimumPossibleSum(testCase.first, testCase.second)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
