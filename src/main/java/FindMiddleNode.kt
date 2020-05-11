import java.util.*

fun <T> findMiddleNode(head: Node<T>?) : Node<T>? {

    println("Input: $head")
    if(head == null) return null
    if(head.next == null) return head

    var slow = head
    var fast = head

    while (fast?.next != null) {
        fast = fast.next

        fast!!.next?.let { next ->
            fast = next
            slow = slow!!.next
        }
        /*if(fast?.next != null) {
            fast = fast!!.next
            slow = slow!!.next
        }*/
    }

    return slow
}

fun main() {
    val head = Node(1)
    head.next = Node(2)
    head.next!!.next = Node(3)
    head.next!!.next!!.next= Node(4)
    println(findMiddleNode(head).toString())

    val head2 = Node(1, Node(2))
    println(findMiddleNode(head2).toString())
}