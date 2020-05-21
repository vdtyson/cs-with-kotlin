package basics

import Node

object SpaceStuff {

    // O(1)
    fun sayHiNTimes(n: Int) {
        for(i in 0..n) {
            println("Hi")
        }
    }

    // O(n)
    fun arrayOfHiNTimes(n: Int): MutableList<String> {
        val list = mutableListOf<String>()
        for(i in 0..n) {
            list.add("HI")
        }
        return list
    }

    // O(n^2)
    fun arrayOfHiNBy2Times(n: Int): MutableList<String> {
        val list = mutableListOf<String>()
        for(i in 0..n) {
            list.add("Hi")
            list.add("Hi")
        }
        return list
    }
}

object TimeStuff {

    // Linear
    fun addNums(arr: IntArray) {

    }

    // Quadratic O(n^2)
    fun bubbleSort(intArray: IntArray) {
        for(i in 0 until intArray.lastIndex) {
            for(j in 0 until intArray.lastIndex) {
                if(intArray[j] > intArray[j + 1]) {
                    val temp = intArray[j]
                    intArray[j] = intArray[j + 1]
                    intArray[j + 1] = temp
                }
            }
        }
    }

    // Logarithmic O(log n)
    fun findMiddleNode(head: Node<Int>): Node<Int> {

        var slowPointer = head
        var fastPointer = head

        while(fastPointer.next != null) {
            fastPointer = fastPointer.next!!
            if(fastPointer.next != null) {
                fastPointer = fastPointer.next!!
                slowPointer = slowPointer.next!!
            }
        }
        return slowPointer
    }

}