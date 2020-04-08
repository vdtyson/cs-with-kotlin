package sorting

import helpers.swap
import java.util.*

// Linear Search -- starts at the beginning of a list of values,
// and checks 1 by 1 in order to get result you are looking for

// Binary Search -- starts in the middle of a sorted array and determines which side(if any)
// the value you are looking for is on. DATA MUST BE SORTED

/*
    [Linear Search]
        - Starts at the beginning of a list of values,and checks 1 by 1 in order to get result you are looking for

    [Binary Search]
        - starts in the middle of a sorted array and determines which side(if any) the value you are looking for is on.
        - DATA MUST BE SORTED

    [Insertion Sort]
        - Consider first item a "sorted" array of length 1 (anytime there's one thing it's always sorted)
        - Start with the second item and insert it into the "sorted" part of the array
        - Repeat the previous step with the next item until all cards in the "sorted" subarray

    [Selection Sort]
        - Select smallest item and move to left. Wash,rinse,repeat
 */

object IterativeSorting {
    fun insertionSort(arr: IntArray): IntArray {
        for ((currentIndex, currentValue) in arr.withIndex()) {
            var previousIndex = currentIndex - 1
            while (previousIndex >= 0) {
                when {
                    arr[previousIndex] > currentValue -> {
                        arr.swap(previousIndex, previousIndex + 1)
                        previousIndex--
                    }

                    else -> previousIndex = -1
                }
            }
        }

        print("${arr.toList()}")
        return arr
    }

    fun selectionSort(arr: IntArray): IntArray {
        // loop through n-1 elements (Array<Int>.indices same as intArray.size - 1)
        for (currentIndex in arr.indices) {
            val indexedMinNumber: IndexedValue<Int>? = arr
                    .sliceArray(IntRange(currentIndex,arr.lastIndex)) // Slice Array by currentIndex
                    .withIndex().minBy { indexedNumber -> indexedNumber.value } // withIndex() returns an IndexedValue<Int>

            indexedMinNumber.let {
                it!!
                arr.swap(it.index + currentIndex, currentIndex)
            }
        }
        //print("${intArray.toList()}")
        return arr
    }

    fun bubbleSort(arr: IntArray): IntArray {
        var swap = true
        while (swap) {
            swap = false
            for (i in arr.indices) {
                if (i < arr.lastIndex && arr[i] > arr[i + 1]) {
                    arr.swap(i, i+1)
                    swap = true
                }
            }
            println(arr.toList())
        }
        return arr
    }

    fun countSort(intArray: IntArray): IntArray {
        TODO("Finish countSort()")
    }
}