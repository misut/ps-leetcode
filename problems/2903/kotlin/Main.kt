fun main() {
    val testCases = listOf(
        Triple(listOf(5, 1, 4, 1).toIntArray(), 2, 4) to listOf(0, 3).toIntArray(),
        Triple(listOf(2, 1).toIntArray(), 0, 0) to listOf(0, 0).toIntArray(),
        Triple(listOf(1, 2, 3).toIntArray(), 2, 4) to listOf(-1, -1).toIntArray(),
        Triple(listOf(31, 23, 36).toIntArray(), 1, 11) to listOf(1, 2).toIntArray(),
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().findIndices(testCase.first, testCase.second, testCase.third)
        println("#$index Expected ${expected.toList()}, Actual ${actual.toList()}")
        expected.contentEquals(actual)
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
