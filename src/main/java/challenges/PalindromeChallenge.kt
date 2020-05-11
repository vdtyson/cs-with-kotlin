package challenges

import challenges.common.Challenge
import util.*

class PalindromeChallenge: Challenge<String?, Boolean>() {
    // Check if something is a palindrome -- if so return true, else return false
    override fun solution(str: String?) : Boolean {

        if(str.isNullOrBlank()) return true

        var frontIndex = 0
        var backIndex = str.lastIndex

        while (frontIndex != backIndex) {
            if(!str[frontIndex].equals(str[backIndex], ignoreCase = true)) return false
            frontIndex++
            backIndex--
        }
        return true
    }

    override fun testSolution(input: String?, expected: Boolean) {
        input.printAsInput()
        val result = solution(input)
        expected checkAgainst result
    }

    override fun runTestCases() {
        "Palindrome Challenge Check 1".challengeCheck {
            testSolution("Madam", expected = true)
        }

        "Palindrome Challenge Check 2" challengeCheck {
            testSolution("Guava", expected = false)
        }

        "Palindrome Challenge Check 3" challengeCheck {
            testSolution("", expected = true)
        }

        "Palindrome Challenge Check 4" challengeCheck {
            testSolution(null, expected = true)
        }

        "Palindrome Challenge Check 5" challengeCheck {
            testSolution("a", expected = true)
        }
    }
}

fun main() {
    PalindromeChallenge().runTestCases()
}