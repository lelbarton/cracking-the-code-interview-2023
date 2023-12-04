package ch3stacksAndQueues

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.NoSuchElementException
import kotlin.test.assertEquals
import kotlin.test.assertNull

class StackWithMinTest {

    private val stack = StackWithMin<Int>()

    @Test
    fun `when pop is called on empty stack, throw an exception`() {
        assertThrows<NoSuchElementException> { stack.pop() }
    }

    @Test
    fun `when values are pushed, they are popped in expected order`() {
        stack.push(2)
        stack.push(5)
        stack.push(10)

        assertEquals(10, stack.pop())
        assertEquals(5, stack.pop())
        assertEquals(2, stack.pop())
    }

    @Test
    fun `when stack is empty, min is null`() {
        assertNull(stack.min())
    }

    @Test
    fun `when stack contains one element, min is that element`() {
        stack.push(3)

        assertEquals(3, stack.min())
    }

    @Test
    fun `when stack contains many elements, min is correctly returned`() {
        stack.push(10)
        stack.push(2)
        stack.push(5)

        assertEquals(2, stack.min())
    }

    @Test
    fun `when min is first seen, min is correctly returned`() {
        stack.push(2)
        stack.push(10)
        stack.push(10)
        stack.push(10)

        assertEquals(2, stack.min())
    }
    @Test
    fun `when min is last seen, min is correctly returned`() {
        stack.push(10)
        stack.push(10)
        stack.push(10)
        stack.push(2)

        assertEquals(2, stack.min())
    }
}
