package ch1strings
/*
 1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 */
class IsUnique {

    // Set access is O(1) and we iterate over the string once, so this runs in O(n)
    fun isUniqueV1(str: String) : Boolean {
        if (str.isEmpty()) return true

        // Mutable set solution included here for completeness,
        // as the more 'classic' solution.
//        val charSet = mutableSetOf<Char>()
//        str.forEach{
//            if (charSet.contains(it)) return false
//            charSet.add(it)
//        }
//        return true

        val charSet = str.toSet()
        return charSet.size == str.length
    }

    // We need to iterate through the string once for each letter it contains, so this runs in O(n^2)
    fun isUniqueNoAdditionalDS(str: String) : Boolean {
        if (str.isEmpty()) return true

        for (i in str.indices) {
            for (k in i+1..<str.length) {
                if (str[i] == str[k]) return false
            }
        }
        return true
    }
}
