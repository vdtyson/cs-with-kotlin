package sorting

object Recursion {

    fun searchForTarget(target: Int, arr: IntArray, i: Int = 0): Boolean =
        when {
            i <= arr.lastIndex ->
                when (arr[i]) {
                    target -> true

                    else -> searchForTarget(target, arr, i + 1)
                }

            else -> false
        }

    // print the nth fib number
    fun recursiveFibonacci(n: Int) {
        /*  Base Case:
                test for negatives
                if n is 0:
                    return 0
                if n is 1:
                    return 1

            If we're not on base case:
                return recursion of n-1 + n-2

        */
    }
    fun getFibonacciArray(targetAmount: Int, currentFibonacciNumber: Int = 0, intArray: IntArray = intArrayOf(0)): IntArray {
        TODO()
    }

    // TODO: Complete the helper function below to merge 2 sorted arrays
    // Merges two sorted pieces back together into a single sorted collection
    fun mergeSortHelper(arrA: IntArray, arrB: IntArray): IntArray {
        val numOfElements = arrA.size + arrB.size
        val mergedArr = intArrayOf()
        TODO("Add code for mergeSortHelper()")
    }

    // TODO: Implement the Merge Sort function below USING RECURSION
    // Handles dividing up the original list or array into a left-hand side and right-hand side
    fun mergeSort(arr: IntArray): IntArray {
        TODO("Add code mergeSort()")
    }

    fun quickSort(arr: IntArray): IntArray {
        TODO()
    }
}