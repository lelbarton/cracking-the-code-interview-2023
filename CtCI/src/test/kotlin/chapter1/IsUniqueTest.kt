package chapter1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsUniqueTest {

    private val isUnique = IsUnique()

    private val uniqueCharStrings = listOf("x", "abcd", "abc£d&e","!@£$", " \t\n")
    private val repeatedCharStrings = listOf("abcda", "abc%d%e", "%^&*&", "xx", "abcdxx", "\t\t\t", "\t \n ")

    @Test
    fun `when string is empty, is unique v1 returns true`() {
        assertTrue(isUnique.isUniqueV1(""))
    }

    @Test
    fun `when string has no repeated characters, is unique v1 returns true`() {
        uniqueCharStrings.forEach { assertTrue(isUnique.isUniqueV1(it)) }
    }

    @Test
    fun `when string has repeated characters, is unique v1 returns false`() {
        repeatedCharStrings.forEach { assertFalse(isUnique.isUniqueV1(it)) }
    }

    @Test
    fun `when string is empty, is unique with no additional data structures returns true`() {
        assertTrue(isUnique.isUniqueNoAdditionalDS(""))
    }

    @Test
    fun `when string has no repeated characters, is unique with no additional data structures returns true`() {
        uniqueCharStrings.map { assertTrue(isUnique.isUniqueNoAdditionalDS(it)) }
    }

    @Test
    fun `when string has repeated characters, is unique with no additional data structures returns false`() {
        repeatedCharStrings.forEach { assertFalse(isUnique.isUniqueNoAdditionalDS(it)) }
    }
}
