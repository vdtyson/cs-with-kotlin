package challenges

private fun reverseString(chars: CharArray) {
    println("Input: ${chars.asList()}")
    var leftIndex = 0
    var rightIndex = chars.lastIndex
    while (leftIndex < rightIndex) {
        val temp = chars[leftIndex]
        chars[leftIndex] = chars[rightIndex]
        chars[rightIndex] = temp
        leftIndex++
        rightIndex--

    }
    println("Output: ${chars.asList()}")
    println()
}

fun main() {
    reverseString(charArrayOf('A', 'B', 'C', 'D', 'E'))
    reverseString(charArrayOf())
    reverseString(charArrayOf('A'))
}