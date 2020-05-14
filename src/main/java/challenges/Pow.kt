package challenges

import challenges.common.Challenge
import kotlin.math.absoluteValue

data class PowParams(val base: Double, val exp: Int)
class Pow: Challenge<PowParams, Double>() {
    override fun solution(input: PowParams): Double {
        val base = input.base
        val exp = input.exp

        val isNegativeExp = exp < 0

        var result = 1.0

        var i = 0
        while(i < exp.absoluteValue) {
            result *= base
            i++
        }

        return when {
            isNegativeExp -> 1/result
            else -> result
        }
    }

    override fun runTestCases() {
        TODO("Not yet implemented")
    }
}