package cn.wegrowth.elearning.domain

import cn.wegrowth.elearning.domain.FooAssertions.Companion.assertThat
import kotlin.test.Test

internal class FooTest {
    @Test
    fun testSum() {
        val foo = Foo(name = "abcd", value = "cded", quantity = 5)
        assertThat(foo)
            .hasName("abcd")
            .hasValue("cded")
            .hasQuantity(5)
    }
}