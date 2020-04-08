package common

import org.junit.jupiter.api.Assertions.assertEquals

interface BaseTest {
}
open class Tester<P>(private val name: String) {
    class NoTestParams
    protected open fun failureMessage(testClassName: String? = ""): String {
        return when(testClassName) {
            null -> "$name failed."
            else -> "$name in $testClassName failed."
        }
    }

    open fun execute(params: P) {}
}