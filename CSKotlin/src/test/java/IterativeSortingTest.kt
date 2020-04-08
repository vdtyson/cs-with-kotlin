import common.BaseTest
import common.Tester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sorting.IterativeSorting.bubbleSort
import sorting.IterativeSorting.countSort
import sorting.IterativeSorting.insertionSort
import sorting.IterativeSorting.selectionSort

class IterativeSortingTest : BaseTest {

    @Test
    fun `insertionSort() should correctly sort IntArray`() {
        Tests.GenericArrayTest(::insertionSort, INSERTION_SORT).executeTest()
       /* Tests.PresortedArrayTest(::insertionSort, INSERTION_SORT).executeTest()
        Tests.RandomArrayTest(::insertionSort, INSERTION_SORT).executeTest()*/
    }

    @Test
    fun `insertionSort() should correctly handle empty IntArray`() {
        Tests.EmptyArrayTest(::insertionSort, INSERTION_SORT).executeTest()
    }

    @Test
    fun `insertionSort() should sort presorted IntArray`() {
        Tests.PresortedArrayTest(::insertionSort, INSERTION_SORT).executeTest()
    }

    @Test
    fun `insertionSort() should sort random IntArray`() {
        Tests.RandomArrayTest(::insertionSort, INSERTION_SORT).executeTest()
    }
    // SELECTION SORTING
    @Test
    fun `selectionSort() should correctly sort IntArray`() {
        Tests.GenericArrayTest(::selectionSort, INSERTION_SORT).executeTest()
        /* Tests.PresortedArrayTest(::insertionSort, INSERTION_SORT).executeTest()
         Tests.RandomArrayTest(::insertionSort, INSERTION_SORT).executeTest()*/
    }

    @Test
    fun `selectionSort() should correctly handle empty IntArray`() {
        Tests.EmptyArrayTest(::selectionSort, INSERTION_SORT).executeTest()
    }

    @Test
    fun `selectionSort() should sort presorted IntArray`() {
        Tests.PresortedArrayTest(::selectionSort, INSERTION_SORT).executeTest()
    }

    @Test
    fun `selectionSort() should sort random IntArray`() {
        Tests.RandomArrayTest(::selectionSort, INSERTION_SORT).executeTest()
    }

    // BUBBLE SORT

    @Test
    fun `bubbleSort() should correctly sort IntArray`() {
        Tests.GenericArrayTest(::bubbleSort, INSERTION_SORT).executeTest()
        /* Tests.PresortedArrayTest(::insertionSort, INSERTION_SORT).executeTest()
         Tests.RandomArrayTest(::insertionSort, INSERTION_SORT).executeTest()*/
    }

    @Test
    fun `bubbleSort() should correctly handle empty IntArray`() {
        Tests.EmptyArrayTest(::bubbleSort, INSERTION_SORT).executeTest()
    }

    @Test
    fun `bubbleSort() should sort presorted IntArray`() {
        Tests.PresortedArrayTest(::bubbleSort, INSERTION_SORT).executeTest()
    }

    @Test
    fun `bubbleSort() should sort random IntArray`() {
        Tests.RandomArrayTest(::bubbleSort, INSERTION_SORT).executeTest()
    }


    @Test
    fun `countSort() should correctly sort generic array of Int`() {
        Tests.GenericArrayTest(::countSort, COUNT_SORT).executeTest()
        Tests.EmptyArrayTest(::countSort, COUNT_SORT).executeTest()
        Tests.PresortedArrayTest(::countSort, COUNT_SORT).executeTest()
        Tests.RandomArrayTest(::countSort, COUNT_SORT).executeTest()
    }

    companion object {
        sealed class Tests(private val fn: (intArray: IntArray) -> IntArray, name: String) : Tester<Tests.IterativeSortingTestParams>(name) {

            inner class IterativeSortingTestParams(val expected: IntArray, val actual: IntArray)
            val params = {expected: IntArray, actual: IntArray ->
                IterativeSortingTestParams(expected,actual)
            }

            override fun failureMessage(testClassName: String?): String {
                return super.failureMessage("IterativeSortingTest")
            }

            override fun execute(params: IterativeSortingTestParams) {
                super.execute(params)
                Assertions.assertEquals(
                        params.expected.toList(),
                        params.actual.toList(),
                        "${failureMessage()}\nExpected: ${params.expected.toList()},Actual: ${params.actual.toList()}")
            }

            abstract fun executeTest()

            class GenericArrayTest(private val fn: (intArray: IntArray) -> IntArray, fnName: String)
                :Tests(fn, "Generic array test for $fnName") {

                override fun executeTest() {
                    execute(params(EXPECTED_GENERIC, fn(GENERIC_ARRAY)))
                }

            }

            class EmptyArrayTest(private val fn: (intArray: IntArray) -> IntArray, fnName: String)
                :Tests(fn, "Empty array test for $fnName") {

                override fun executeTest() {
                    execute(params(EXPECTED_EMPTY, fn(EMPTY_ARRAY)))
                }
            }

            class PresortedArrayTest(private val fn: (intArray: IntArray) -> IntArray, fnName: String)
                :Tests(fn, "Presorted array test for $fnName" ) {
                override fun executeTest() {
                    execute(params(EXPECTED_PRESORTED, fn(PRESORTED_ARRAY)))
                }
            }

            class RandomArrayTest(private val fn: (intArray: IntArray) -> IntArray, fnName: String)
                : Tests(fn, "Random array test for $fnName") {
                override fun executeTest() {
                    val randomArray = RANDOM_ARRAY.invoke()
                    val expected = EXPECTED_RANDOM(randomArray)
                    execute(params(expected, fn(randomArray)))
                }
            }
        }

        private const val INSERTION_SORT = "insertionSort()"
        private const val SELECTION_SORT = "selectionSort()"
        private const val BUBBLE_SORT = "bubbleSort()"
        private const val COUNT_SORT = "countSort()"

        private val GENERIC_ARRAY = intArrayOf(1, 5, 8, 4, 2, 9, 6, 0, 3, 7)
        private val EMPTY_ARRAY = intArrayOf()
        private val PRESORTED_ARRAY = intArrayOf(0, 1, 2, 3, 4, 5)
        private val RANDOM_ARRAY: () -> IntArray = {
            val list = mutableListOf<Int>()
            val intRange = IntRange(0, 200)
            for (i in 0 until 50) {
                list.add(intRange.random())
            }
            list.toIntArray()
        }

        private val EXPECTED_GENERIC = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        private val EXPECTED_EMPTY = intArrayOf()
        private val EXPECTED_PRESORTED = intArrayOf(0,1, 2, 3, 4, 5)
        private val EXPECTED_RANDOM: (IntArray) -> IntArray = { array: IntArray -> array.sortedArray() }

    }
}

