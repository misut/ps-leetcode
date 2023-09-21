fun main() {
    val testCases = listOf(
        Pair(
            Triple(3, 2, 15),
            Triple(listOf(listOf(1, 1, 1), listOf(1, 1, 10)), listOf(0, 0, 0), listOf(1, 2, 3))
        ) to 2,
        Pair(
            Triple(3, 2, 15),
            Triple(listOf(listOf(1, 1, 1), listOf(1, 1, 10)), listOf(0, 0, 100), listOf(1, 2, 3))
        ) to 5,
        Pair(
            Triple(2, 3, 10),
            Triple(listOf(listOf(2, 1), listOf(1, 2), listOf(1, 1)), listOf(1, 1), listOf(5, 5))
        ) to 2,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().maxNumberOfAlloys(
            testCase.first.first,
            testCase.first.second,
            testCase.first.third,
            testCase.second.first,
            testCase.second.second,
            testCase.second.third
        )
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
