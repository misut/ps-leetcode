fun main() {
    val testCases = listOf(
        arrayOf(51,71,17,24,42) to 88,
        arrayOf(1,2,3,4) to -1
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().maxSum(testCase.toIntArray())
        println("#$index Expected $expected, Actual $actual")
        expected == actual
    }.also {
        remaining -> println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}