package ch3stacksAndQueues

/*
How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element?
Push, pop, and min should all operate in O(1) time.
 */
class StackWithMin<T: Comparable<T>> {

    private val stack: MutableList<T> = mutableListOf()
    private var min: T? = null

    fun pop() : T {
        // Kotlin implementation for both last() and removeLast()
        // uses the tracked index of the last element, and therefore they run in O(1)
        val top = stack.last()
        stack.removeLast()
        return top
    }

    fun push(value: T) {
        if (min == null || value < min!!) {
            min = value
        }
        stack.add(value)
    }

    fun min() : T? = min
}
