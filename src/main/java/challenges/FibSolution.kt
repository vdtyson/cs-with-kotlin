package challenges

private fun fibSolution(n: Int): Int {
    when(n) {
        0 -> return 0
        1 -> return 1
    }

    return fibSolution(n - 1) + fibSolution(n - 2)
}