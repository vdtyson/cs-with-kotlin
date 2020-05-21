package basics

/*
Sorting - arranging the elements in a list or collection in increasing or decreasing order of some property
    ex: 1,2,3,4

 */
object Sorting {

    // Sorts array by repeatedly finding the minimum element from unsorted part and putting it at the beginning
    // O(n^2)
    fun selectionSort(arr: IntArray) {
        for (i in 0 until arr.lastIndex) {

            // Assign i to the initial minimum element
            var minIndex = i
            for (j in (i + 1)..arr.lastIndex) {
                // If current element is greater than are minimum element, current element is now minimum
                if (arr[minIndex] > arr[j]) {
                    minIndex = j
                }
            }

            // if an element was found that was smaller than the original index value, swap the elements
            // O(n^2)
            if (minIndex != i) {
                val temp = arr[i]
                arr[i] = arr[minIndex]
                arr[minIndex] = temp
            }
        }
    }

    // Repeatedly steps through lists, compares adjacent elements and swaps them if they are in the wrong order
    // O(n^2)
    fun bubbleSort(arr: IntArray) {
        // Step through for each element
        for (i in 0 until arr.lastIndex) {
            for (j in 0 until arr.lastIndex) {
                // If current element is greater than the next, swap them
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
    }

    // Divide arr into unsorted subset and sorted subset (initially containing only first element)
    // Pick up one item from the unsorted subset and put it into the sorted subset
    // O(n^2)
    fun insertionSort(arr: IntArray) {
        if (arr.size <= 1) return
        // Start with index 1 (index 0 is already sorted)
        for (i in 1..arr.lastIndex) {
            var j = i
            while (j != 0 && arr[j] < arr[j - 1]) {
                val temp = arr[j]
                arr[j] = arr[j - 1]
                arr[j - 1] = temp
                j--
            }
        }
    }

    // Time complexity: O(n log n) Space complexity: O(n)
    // Not an in-place algorithm
    fun mergeSort(arr: IntArray) {
        // Split up array recursively and merge
        // Reduce until we only have one element in the sublist
        if(arr.size < 2) return
        val mid = arr.size / 2
        val leftSubArr = IntArray(mid)
        val rightSubArr = IntArray(arr.size - mid)

        for(i in 0 until mid) {
            leftSubArr[i] = arr[i]
        }

        for(i in mid..arr.lastIndex) {
            rightSubArr[i - mid] = arr[i]
        }

        mergeSort(leftSubArr)
        mergeSort(rightSubArr)
        merge(leftSubArr, rightSubArr, arr)
    }


    fun merge(l: IntArray, r: IntArray, original: IntArray) {

        var lIndex = 0
        var rIndex = 0
        var originalIndex = 0

        while (lIndex < l.size && rIndex < r.size) {
            when {
                l[lIndex] <= r[rIndex] -> {
                    original[originalIndex] = l[lIndex]
                    lIndex++
                }
                else -> {
                    original[originalIndex] = r[rIndex]
                    rIndex++
                }
            }
            originalIndex++
        }

        while(lIndex < l.size) {
            original[originalIndex] = l[lIndex]
            originalIndex++
            lIndex ++
        }

        while(rIndex < r.size) {
            original[originalIndex] = r[rIndex]
            originalIndex++
            rIndex++
        }

    }

    // Average case running time: O(n Log n) Very high probability! ; Worst case: o(n^2)
    // in place (O(1))
    fun quickSort(arr: IntArray, left: Int = 0, right: Int = arr.lastIndex) {

        val index = partition(arr, left, right)
        // Sorting left half
        if(left < index - 1) quickSort(arr, left,index-1)
        // Sorting right half
        if(index < right) quickSort(arr, index, right)
    }

    fun partition(arr: IntArray, l: Int, r: Int): Int {

        var left = l
        var right = r
        val pivot = arr[(left + right) / 2] // Pivot point

        while(left <= right) {

            while(arr[left] < pivot) left++ // Finds elements on left that should be on right
            while(arr[right] > pivot) right-- // Finds elements on right that should be on left

            // Swap elements and move left and right indices
            if(left <= right) {
                val temp = arr[left]
                arr[left] = arr[right]
                arr[right] = temp
            }
        }
        return left
    }
}

fun main() {
    val arr = intArrayOf(4, 3, 5, 9, 6, 8)
    println("Input: ${arr.toList()}")
    Sorting.quickSort(arr, 0, arr.lastIndex)
    println("Output: ${arr.toList()}")
}