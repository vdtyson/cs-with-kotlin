import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sorting.Recursion

class RecursionTest {

    @Test
    fun `searchArrayForTarget() should return true`() {
        // SETUP
        val targetNumber = 8
        val arr = intArrayOf(1,4,5,8)
        val expected = true
        val actual: Boolean
        // EXECUTE
        actual = Recursion.searchForTarget(targetNumber,arr)
        // CHECK
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `searchArrayForTarget() should return false`() {
        // SETUP
        val targetNumber = 10
        val arr = intArrayOf(1,4,5,8)
        val expected = false
        val actual: Boolean
        // EXECUTE
        actual = Recursion.searchForTarget(targetNumber,arr)
        // CHECK
        Assertions.assertEquals(expected, actual)
    }
}