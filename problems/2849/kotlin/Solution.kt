import kotlin.math.abs

class Solution {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val minTime = maxOf(abs(sx - fx), abs(sy - fy))
        val maxTime = abs(sx - fx) + abs(sy - fy)

        return if (t < minTime) {
            false
        } else if(t in minTime..maxTime) {
            true
        } else {
            if (minTime < maxTime) {
                true
            } else {
                t != 1
            }
        }
    }
}
