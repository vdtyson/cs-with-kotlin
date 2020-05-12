package challenges

import challenges.common.Challenge
import util.checkAgainst

data class BasicBinarySearchParams(val arr: IntArray, val target: Int)
class BasicBinarySearch: Challenge<BasicBinarySearchParams, Boolean>() {
    override fun solution(params: BasicBinarySearchParams): Boolean {
        val arr = params.arr
        val target = params.target

        if(arr.isEmpty()) return false

        var leftIndex = -1
        var rightIndex = arr.lastIndex
        while (leftIndex <= rightIndex) {

            val middleIndex = (leftIndex + rightIndex) / 2
            val guessNum = arr[middleIndex]

            when {
                target == guessNum -> return true
                target > guessNum -> leftIndex = middleIndex + 1
                else -> rightIndex = middleIndex - 1
            }
        }

        return false
    }

    override fun runTestCases() {
        TODO("Add test cases for binary search")
    }
}

fun main() {
    val basicBinarySearch = BasicBinarySearch()
    basicBinarySearch.runTestCases()
}