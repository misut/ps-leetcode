fun main() {
    val testCases = listOf(
        Triple(listOf(3, 2, 4), 2, 1) to 3L,
        Triple(listOf(3, 1, 9, 6), 3, 0) to 2L,
        Triple(listOf(6, 5, 6), 6, 0) to 1L,
        Triple(listOf(1, 9, 6, 1), 2, 1) to 6L,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().countInterestingSubarrays(testCase.first, testCase.second, testCase.third)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
