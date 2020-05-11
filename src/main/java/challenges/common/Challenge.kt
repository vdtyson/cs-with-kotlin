package challenges.common

abstract class Challenge<in Input, Output> {
    protected abstract fun solution(input: Input) : Output
    protected abstract fun testSolution(input: Input, expected: Output)
    open fun runTestCases() {}
}