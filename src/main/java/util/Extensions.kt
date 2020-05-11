package util

import kotlin.math.exp

infix fun String.challengeCheck(fn: () -> Unit) {
    println("---$this---")
    fn()
    println()
}

fun Any?.printAsInput() {
    println("Input: $this")
}

fun Any?.printAsActual() {
    println("Actual: $this")
}

fun Any?.printAsExpected() {
    println("Expected: $this")
}

fun <T> checkResult(actual: T, expected: T) {
    when {
        actual == expected -> println("Success!")
        else -> println("Failure")
    }
    println("Actual: $actual, Expected: $expected")
}

infix fun <T> T.checkAgainst(actual: T) {
    checkResult(actual, this)
}