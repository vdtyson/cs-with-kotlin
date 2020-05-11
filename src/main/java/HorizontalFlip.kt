private fun horizontalFlip(matrix: Array<IntArray>) {
    // If array has only one row or now rows, do nothing
    if (matrix.size == 1 || matrix.isEmpty()) return

    var leftRowIndex = 0
    var rightRowIndex = matrix.size - 1

    // Handle like reversing string; walk leftIndex and rightIndex to the middle
    while(leftRowIndex < rightRowIndex) {
        // Assign temp value to inital leftRow value
        val tempArr = matrix[leftRowIndex]

        // Swap rows
        matrix[leftRowIndex] = matrix[rightRowIndex]
        matrix[rightRowIndex] = tempArr

        // Walk leftRowIndex up 1 and rightRowIndex down 1
        leftRowIndex++
        rightRowIndex--
    }
}