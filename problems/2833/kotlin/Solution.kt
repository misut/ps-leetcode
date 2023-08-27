class Solution {
    fun furthestDistanceFromOrigin(moves: String): Int {
        var numUnderscores = 0
        var numLefts = 0
        var numRights = 0
        moves.forEach { char ->
            when(char) {
                'L' -> numLefts++
                'R' -> numRights++
                else -> numUnderscores++
            }
        }

        return if (numLefts >= numRights) {
            numLefts - numRights + numUnderscores
        } else {
            numRights - numLefts + numUnderscores
        }
    }
}