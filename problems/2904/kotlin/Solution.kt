class Solution {
    fun shortestBeautifulSubstring(s: String, k: Int): String {
        val init = s.indexOfFirst { it == '1' }
        if (init == -1) {
            return ""
        }

        val indices = mutableListOf(init)
        for (i in 1..<k) {
            val idx = s.substring(indices.last() + 1).indexOfFirst { it == '1' }
            if (idx == -1) {
                return ""
            }
            indices.add(idx + indices.last() + 1)
        }
        println(indices)

        var min = indices.first() to indices.last()
        while (true) {
            val idx = s.substring(indices.last() + 1).indexOfFirst { it == '1' }
            if (idx == -1) {
                break
            }
            indices.add(idx + indices.last() + 1)
            indices.removeFirst()

            if (min.second - min.first > indices.last() - indices.first() ||
                (min.second - min.first == indices.last() - indices.first() &&
                    s.slice(min.first..min.second) > s.slice(indices.first()..indices.last()))
            ) {
                min = indices.first() to indices.last()
            }
        }

        return s.slice(min.first..min.second)
    }
}
