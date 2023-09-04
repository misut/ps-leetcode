class Solution {
    fun minimumOperations(num: String): Int {
        var answer = Int.MAX_VALUE

        val queue = mutableListOf<Char>()
        var result = 0
        for (ch in num.reversed()) {
            if (queue.isEmpty() && ch == '5') {
                queue.add(ch)
                continue
            }

            if (queue.isNotEmpty() && queue.last() == '5' && ch == '2') {
                queue.add(ch)
                break
            }

            result += 1
        }
        if (queue.joinToString("").reversed() == "25") {
            answer = minOf(answer, result)
        } else {
            answer = minOf(answer, result + queue.size)
        }


        queue.clear()
        result = 0
        for (ch in num.reversed()) {
            if (queue.isEmpty() && ch == '0') {
                queue.add(ch)
                continue
            }

            if (queue.isNotEmpty() && queue.last() == '0' && ch == '5') {
                queue.add(ch)
                break
            }

            result += 1
        }
        if (queue.joinToString("").reversed() == "50") {
            answer = minOf(answer, result)
        } else {
            answer = minOf(answer, result + queue.size)
        }

        queue.clear()
        result = 0
        for (ch in num.reversed()) {
            if (queue.isEmpty() && ch == '5') {
                queue.add(ch)
                continue
            }

            if (queue.isNotEmpty() && queue.last() == '5' && ch == '7') {
                queue.add(ch)
                break
            }

            result += 1
        }
        if (queue.joinToString("").reversed() == "75") {
            answer = minOf(answer, result)
        } else {
            answer = minOf(answer, result + queue.size)
        }

        queue.clear()
        result = 0
        for (ch in num.reversed()) {
            if (queue.isEmpty() && ch == '0') {
                queue.add(ch)
                continue
            }

            if (queue.isNotEmpty() && queue.last() == '0' && ch == '0') {
                queue.add(ch)
                break
            }

            result += 1
        }
        if (queue.joinToString("").reversed() == "00") {
            answer = minOf(answer, result)
        } else {
            answer = minOf(answer, result + queue.size)
        }

        if (queue.size == 1 && queue.last() == '0') {
            answer = minOf(answer, num.length - 1)
        }

        return answer
    }
}
