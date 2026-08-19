public class maxSubarraySum {

    // Brute Force Approach
    // Generate every possible subarray and calculate its sum
    public static int maxSubArraySumBrute(int arr[]) {

        int maxSum = 0;

        // Select the starting index
        for (int i = 0; i < arr.length; i++) {

            // Select the ending index
            for (int j = i; j < arr.length; j++) {

                int sum = 0;

                // Calculate the sum of the current subarray
                for (int k = i; k <= j; k++) {
                    sum += arr[k];

                    // Update maximum sum
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }

        return maxSum;
    }

    // Better Approach
    // Avoid recalculating the sum by maintaining
    // the current subarray sum
    public static int maxSubArraySumBetter(int arr[]) {

        int maxSum = 0;

        // Select the starting index
        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            // Extend the subarray and keep adding elements
            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                // Update maximum sum
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    // Optimal Approach - Kadane's Algorithm
    public static int maxSubArraySumOptimal(int arr[]) {

        // Initialize with the smallest possible integer
        // so that all-negative arrays are handled correctly
        int maxsum = Integer.MIN_VALUE;

        int cs = 0;

        // Traverse the array once
        for (int i = 0; i < arr.length; i++) {

            // Add the current element to the current subarray sum
            cs += arr[i];

            // Update the maximum subarray sum
            maxsum = Math.max(maxsum, cs);

            // If current sum becomes negative,
            // start a new subarray
            if (cs < 0) {
                cs = 0;
            }
        }

        return maxsum;
    }

    public static void main(String[] args) {

        // Sample array containing all negative numbers
        int arr[] = {-2, -2, -4, -1, -2, -1, -5, -3};

        // Find the maximum subarray sum using Kadane's Algorithm
        System.out.println(maxSubArraySumOptimal(arr));
    }
}