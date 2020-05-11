
data class Node<T>(var data: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return when(next) {
            null -> data.toString()
            else -> "${data.toString()} -> ${next.toString()}"
        }
    }
}