class Solution {
    fun minimumMoves(grid: Array<IntArray>): Int {
        val queue = mutableListOf(grid to 0)
        val visited = mutableSetOf(grid.stringify())

        while(true) {
            val (board, moves) = queue.removeFirst()
            if (board.isCoveredAll()) {
                return moves
            }
            queue.addAll(board.spread().filter { visited.add(it.stringify()) }.map { it to moves + 1 })
        }
    }
}

fun Array<IntArray>.forEachCells(action: (Int) -> Unit) = this.forEachCellsWithPosition { _, i -> action(i) }

fun Array<IntArray>.forEachCellsWithPosition(action: (Pair<Int, Int>, Int) -> Unit) = this.forEachIndexed { col, list ->
    list.forEachIndexed { row, num -> action(col to row, num) }
}

fun Array<IntArray>.isCoveredAll(): Boolean {
    var covered = true
    this.forEachCells {
        if (it != 1) {
            covered = false
            return@forEachCells
        }
    }
    return covered
}

fun Array<IntArray>.spread(): List<Array<IntArray>> {
    val boards = mutableListOf<Array<IntArray>>()
    val (cols, rows) = size to first().size
    this.forEachCellsWithPosition { pos, stones ->
        if (stones > 1) {
            pos.adjacents().forEach {
                if (it.first in (0 until cols) && it.second in (0 until rows)) {
                    val board = this.copy()
                    board[pos.first][pos.second] = stones - 1
                    board[it.first][it.second] += 1
                    boards.add(board)
                }
            }
        }
    }
    return boards
}

fun Array<IntArray>.copy(): Array<IntArray> {
    val (cols, rows) = size to first().size
    return Array(cols) { col -> IntArray(rows) { row -> this[col][row] } }
}

fun Array<IntArray>.stringify(): String {
    val buffer = StringBuffer()
    this.forEachCells { buffer.append(it.digitToChar()) }
    return buffer.toString()
}

fun Pair<Int, Int>.adjacents(): List<Pair<Int, Int>> = listOf(first - 1 to second, first + 1 to second, first to second - 1, first to second + 1)
