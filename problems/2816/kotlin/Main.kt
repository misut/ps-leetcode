fun main() {
    val testCases = listOf(
        ListNode(1).also { it.next = ListNode(8).also { it.next = ListNode(9) } } to
                ListNode(3).also { it.next = ListNode(7).also { it.next = ListNode(8) } },
        ListNode(9).also { it.next = ListNode(9).also { it.next = ListNode(9) } } to
                ListNode(1).also { it.next = ListNode(9).also { it.next = ListNode(9).also { it.next = ListNode(8) } } }
    )

    testCases.filterIndexed { index, (testCase, expected) ->
        val actual = Solution().doubleIt(testCase)
        println("#$index Expected ${expected.stringify()}, Actual ${actual?.stringify()}")
        expected.stringify() == actual?.stringify()
    }.also { remaining ->
        println("You hit ${remaining.size}, failed ${testCases.size - remaining.size}.")
    }
}