package ch8recursionAndDynamicProgramming;

public class MagicIndex {

    // As per question, assume array is sorted
    public int findMagicIndexBruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr[i]) return i;
        }
        return -1;
    }

    public int findMagicIndex(int[] arr) {
        if (arr.length == 0) return -1;
        return findMagicIndexRecursive(arr, 0, arr.length - 1);
    }

    private int findMagicIndexRecursive(int[] arr, int start, int end) {
        if (end < start) return -1;
        int midIndex = (start + end) / 2;
        int midVal = arr[midIndex];

        if (midIndex == midVal) return midIndex;
        if (midIndex > midVal) return findMagicIndexRecursive(arr, midIndex, end);
        return findMagicIndexRecursive(arr, start, midIndex);
    }
}
