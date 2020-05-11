package challenges

import challenges.common.Challenge
import util.challengeCheck
import util.checkAgainst

class BubbleSortChallenge : Challenge<IntArray, IntArray>() {
    override fun solution(input: IntArray): IntArray {

        // Walk through array until last index
        for (step in 0 until input.lastIndex) {

            // At every step, walk through array again
            for(i in 0 until input.lastIndex) {

                // If the value at index i is greater than value at i + 1
                // Swap values
                if(input[i] > input[i + 1]) {
                    val temp = input[i]
                    input[i] = input[i + 1]
                    input[i + 1] = temp
                }
                
                // Otherwise, i will point to i + 1

            }
        }

        return input
    }

    override fun testSolution(input: IntArray, expected: IntArray) {
        val result = solution(input)
        expected.toList() checkAgainst result.toList()
    }

    override fun runTestCases() {
        "Bubble Sort Check 1" challengeCheck {
            testSolution(
                    input = intArrayOf(4,12,4,78,7,-1),
                    expected = intArrayOf(-1,4,4,7,12,78)
            )
        }

        "Bubble Sort Check 2" challengeCheck {
            testSolution(
                    input = intArrayOf(4),
                    expected = intArrayOf(4)
            )
        }

        "Bubble Sort Check 3" challengeCheck {
            testSolution(
                    input = intArrayOf(),
                    expected = intArrayOf()
            )
        }

        "Bubble Sort Check 4" challengeCheck {
            testSolution(
                    input = intArrayOf(52,3,2),
                    expected = intArrayOf(2,3,52)
            )
        }
    }
}

fun main() {
    BubbleSortChallenge().runTestCases()
}