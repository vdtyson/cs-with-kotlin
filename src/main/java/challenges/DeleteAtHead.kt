package challenges

import Node
import challenges.common.Challenge
import util.challengeCheck
import util.checkAgainst

class DeleteAtHead<T>: Challenge<Node<T>?, Node<T>?>() {
    override fun solution(input: Node<T>?): Node<T>? =
            when(input) {
                null -> null
                else -> input.next
            }

    override fun testSolution(input: Node<T>?, expected: Node<T>?) {
        val result = solution(input)
        expected checkAgainst result
    }

    override fun runTestCases() {
        TODO(" Add test cases for delete at head challenge")
    }
}

fun main() {
    val deleteAtHead = DeleteAtHead<Int>()
    deleteAtHead.runTestCases()
}