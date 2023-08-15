class Solution {
    fun doubleIt(head: ListNode?): ListNode? {
        if (head == null) return null

        val next = doubleIt(head.next)
        val res = (head.`val` * 2).let { num ->
            if (num >= 10) {
                ListNode(num / 10).also { it.next = ListNode(num % 10).also {
                    if (head.next?.let { it.`val` >= 5 } ?: false) {
                        it.`val` += 1
                        it.next = next?.next
                    } else {
                        it.next = next
                    }
                } }
            } else {
                ListNode(num).also {
                    if (head.next?.let { it.`val` >= 5 } ?: false) {
                        it.`val` += 1
                        it.next = next?.next
                    } else {
                        it.next = next
                    }
                }
            }
        }
        return res
    }
}

fun ListNode.stringify(): String {
    var cur: ListNode? = this
    var res = ""
    while (cur != null) {
        res += cur.`val`.toString()
        cur = cur.next
    }
    return res
}