fun main() {
    val testCases = listOf(
        listOf(12, 6, 1, 2, 7).toIntArray() to 77L,
        listOf(1, 10, 3, 4, 19).toIntArray() to 133L,
        listOf(1, 2, 3).toIntArray() to 0L,
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().maximumTripletValue(testCase)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}
