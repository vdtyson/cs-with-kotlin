package challenges

import challenges.common.Challenge

class ReplaceSpacesInString: Challenge<ReplaceSpacesInString.Params, String>() {

    data class Params(val a: String, val b: String)

    override fun solution(input: Params): String {
        val a = input.a
        val b = input.b
        val bAsList = b.toList()
        val charList = mutableListOf<Char>()

        for(character in a) {
            when(character) {
                ' ' -> charList.addAll(bAsList)
                else -> charList.add(character)
            }
        }

        return charList.toCharArray().toString()
    }

    override fun runTestCases() {
        TODO("Add test cases for ReplaceStringAWithB challenge")
    }
}

fun main() {
    val replaceSpacesInString = ReplaceSpacesInString()
    replaceSpacesInString.runTestCases()
}