import java.util.Arrays;
import java.util.HashSet;

public class longestConsecutiveSequence {

    // Linear Search
    // Checks whether the given number exists in the array
    public static boolean linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {

            // If the number is found, return true
            if (arr[i] == num) {
                return true;
            }
        }

        // Number is not present in the array
        return false;
    }

    // Brute Force Approach
    // For every element, check whether the next consecutive
    // elements exist using linear search
    public static int longestConsecutiveSequenceBrute(int arr[]) {

        // If the array is empty, no consecutive sequence exists
        if (arr.length == 0) {
            return 0;
        }

        int longestLength = 1;

        // Consider every element as the starting point
        for (int i = 0; i < arr.length; i++) {

            int x = arr[i];
            int cnt = 1;

            // Check whether the next consecutive number exists
            while (linearSearch(arr, x + 1)) {
                x += 1;
                cnt += 1;
            }

            // Update the longest sequence length
            longestLength = Math.max(longestLength, cnt);
        }

        return longestLength;
    }

    // Better Approach
    // Sort the array and then find consecutive elements
    public static int longestConsecutiveSequenceBetter(int arr[]) {

        int n = arr.length;

        // If the array is empty, return 0
        if (n == 0) {
            return 0;
        }

        // Sort the array so consecutive elements come together
        Arrays.sort(arr);

        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;

        // Traverse the sorted array
        for (int i = 0; i < n; i++) {

            // Current element is consecutive to the previous element
            if (arr[i] - 1 == lastSmaller) {
                cnt++;
                lastSmaller = arr[i];
            }

            // Current element is not consecutive and is not a duplicate
            else if (arr[i] != lastSmaller) {
                cnt = 1;
                lastSmaller = arr[i];
            }

            // Update the longest sequence length
            longest = Math.max(longest, cnt);
        }

        return longest;
    }

    // Optimal Approach
    // Use HashSet for O(1) average-time lookup
    public static int longestConsecutiveSequenceOptimal(int arr[]) {

        int n = arr.length;

        // If the array is empty, return 0
        if (n == 0) {
            return 0;
        }

        // Store all elements in a HashSet
        // HashSet automatically handles duplicate elements
        HashSet<Integer> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st.add(arr[i]);
        }

        int longest = 1;

        // Traverse through all unique elements
        for (int it : st) {

            // If the previous element does not exist,
            // this is the beginning of a consecutive sequence
            if (!st.contains(it - 1)) {

                int cnt = 1;
                int x = it;

                // Find all consecutive elements
                while (st.contains(x + 1)) {
                    x++;
                    cnt++;
                }

                // Update the longest sequence length
                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        // Sample input
        int[] arr = {100, 4, 200, 1, 3, 2};

        // Brute Force Approach
        System.out.println(longestConsecutiveSequenceBrute(arr));

        // Better Approach
        System.out.println(longestConsecutiveSequenceBetter(arr));

        // Optimal Approach
        System.out.println(longestConsecutiveSequenceOptimal(arr));
    }
}