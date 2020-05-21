package basics

class ValidParenthiss {
    fun isValid(s: String): Boolean {
        val bracketStack = mutableListOf<Char>()

        s.forEach { char ->
            when {
                openToClosedBracket.containsKey(char) -> bracketStack.add(char)
                else -> {
                    val last = bracketStack.pop()
                    if(openToClosedBracket[last] != char) return false
                }
            }
        }

        return true
    }

    fun MutableList<Char>.pop(): Char = removeAt(lastIndex)

    val openToClosedBracket =
            hashMapOf(
                    '(' to ')',
                    '{' to '}',
                    '[' to ']'
            )
}