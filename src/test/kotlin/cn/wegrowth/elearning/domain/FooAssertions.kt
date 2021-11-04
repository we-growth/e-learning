package cn.wegrowth.elearning.domain

import org.assertj.core.api.AbstractObjectAssert
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat

class Foo(
    val name: String,
    val value: String,
    val quantity: Int
)

class FooAssertions : Assertions() {
    companion object {
        fun assertThat(actual: Foo) = FooAssert(actual)
    }
}

class FooAssert(actual: Foo) :
    AbstractObjectAssert<FooAssert, Foo>(actual, FooAssert::class.java) {
    fun hasName(name: String): FooAssert {
        assertThat(actual.name).isEqualTo(name)
        return this
    }

    fun hasValue(value: String): FooAssert {
        assertThat(actual.value).isEqualTo(value)
        return this
    }

    fun hasQuantity(quantity: Int): FooAssert {
        assertThat(actual.quantity).isEqualTo(quantity)
        return this
    }
}


