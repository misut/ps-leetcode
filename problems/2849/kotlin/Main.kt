fun main() {
    val testCases = listOf(
        listOf(2, 4, 7, 7, 6) to true,
        listOf(3, 1, 7, 3, 3) to false,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().isReachableAtTime(testCase[0], testCase[1], testCase[2], testCase[3], testCase[4])
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
