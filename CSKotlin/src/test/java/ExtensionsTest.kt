import common.BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import helpers.swap

class ExtensionsTest: BaseTest {
    @Test
    fun `IntArray extension fun swap() should correctly swap values at specified index`() {
        // SETUP
        val arr = intArrayOf(1,2,3,4,5)
        val index1 = 0
        val index2 = 4
        val expected = listOf(5,2,3,4,1)
        // EXECUTE
        arr.swap(index1,index2)
        // CHECK
        Assertions.assertEquals(expected, arr.asList())
    }
}