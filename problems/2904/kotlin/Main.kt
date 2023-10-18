fun main() {
    val testCases = listOf(
        ("100011001" to 3) to "11001",
        ("1011" to 2) to "11",
        ("000" to 1) to "",
        ("001110101101101111" to 10) to "10101101101111",
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().shortestBeautifulSubstring(testCase.first, testCase.second)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
