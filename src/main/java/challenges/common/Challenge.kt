package challenges.common

import util.checkAgainst

abstract class Challenge<in Input, Output> {
    protected abstract fun solution(input: Input) : Output
    protected open fun testSolution(input: Input, expected: Output) {
        expected checkAgainst solution(input)
    }
    abstract fun runTestCases()
}