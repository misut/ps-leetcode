fun main() {
    val testCases = listOf(
        listOf(3, 2, 3, 2, 3).toIntArray() to 2,
        listOf(10, 10, 10, 3, 1, 1).toIntArray() to 4,
        listOf(1, 1, 3, 3, 1, 1, 2, 2, 3, 1, 3, 2).toIntArray() to 5,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().minGroupsForValidAssignment(testCase)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
