import java.util.*;

public class longestSubarrayWithSumK {

    // Brute Force Approach
    // Finds the longest subarray whose sum is equal to K
    public static int longestLengthSubarrayWithSumKBrute(int arr[], int t) {
        int longestLength = 0;

        // Select the starting index
        for (int i = 0; i < arr.length; i++) {

            // Select the ending index
            for (int j = i; j < arr.length; j++) {

                int sum = 0;

                // Calculate the sum of the current subarray
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                // Update the longest length if sum equals target
                if (sum == t) {
                    longestLength = Math.max(longestLength, j - i + 1);
                }
            }
        }

        return longestLength;
    }

    // Better Approach using HashMap and Prefix Sum
    // Works with positive, zero, and negative numbers
    public static int longestLengthSubarrayWithSumKBetter(int arr[], int k) {
        HashMap<Long, Integer> map = new HashMap<>();

        long sum = 0;
        int maxlen = 0;

        for (int i = 0; i < arr.length; i++) {

            // Calculate prefix sum
            sum += arr[i];

            // If prefix sum itself equals K,
            // subarray from index 0 to i has sum K
            if (sum == k) {
                maxlen = Math.max(maxlen, i + 1);
            }

            // Required previous prefix sum
            long rem = sum - k;

            // If this prefix sum existed before,
            // the subarray between those indices has sum K
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxlen = Math.max(maxlen, len);
            }

            // Store the first occurrence of the prefix sum
            // to get the longest possible subarray
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxlen;
    }

    // Optimal Approach using Sliding Window / Two Pointers
    // Works when the array contains only non-negative numbers
    public static int longestLengthSubarrayWithSumKOptimal(int arr[], int k) {
        int left = 0;
        int right = 0;
        int maxlen = 0;
        int sum = arr[0];

        while (right < arr.length) {

            // Shrink the window if the sum becomes greater than K
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            // If current window sum equals K,
            // update the maximum length
            if (sum == k) {
                maxlen = Math.max(maxlen, right - left + 1);
            }

            // Expand the window
            right++;

            if (right < arr.length) {
                sum += arr[right];
            }
        }

        return maxlen;
    }

    public static void main(String[] args) {

        // Sample array containing non-negative numbers
        int arr[] = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};

        // Find the longest subarray with sum equal to 3
        System.out.println(longestLengthSubarrayWithSumKOptimal(arr, 3));
    }
}