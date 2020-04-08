package helpers

import java.util.*

// For swapping index values easily in IntArray
fun IntArray.swap(index1: Int, index2: Int) {
    val initialIndex1Value = this[index1]
    this[index1] = this[index2]
    this[index2] = initialIndex1Value
}

