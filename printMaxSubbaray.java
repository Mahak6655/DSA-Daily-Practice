import java.util.Arrays;

public class printMaxSubbaray {

    // Kadane's Algorithm to find and print the maximum subarray
    public static void printMaxSubbarySum(int arr[]) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < arr.length; i++) {

            // Store the starting index of a new subarray
            if (sum == 0) {
                start = i;
            }

            // Add the current element to the current sum
            sum += arr[i];

            // Update maximum sum and store the boundaries
            // whenever a new maximum sum is found
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            // If the current sum becomes negative,
            // start a new subarray from the next index
            if (sum < 0) {
                sum = 0;
            }
        }

        // Print the maximum subarray
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Sample input
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        // Find and print the maximum subarray
        printMaxSubbarySum(arr);
    }
}