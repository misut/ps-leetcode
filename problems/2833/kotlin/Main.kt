fun main() {
    val testCases = listOf(
        "L_RL__R" to 3,
        "_R__LL_" to 5,
        "_______" to 7
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().furthestDistanceFromOrigin(testCase)
        println("#$index Expected ${expected}, Actual ${actual}")
        expected == actual
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}