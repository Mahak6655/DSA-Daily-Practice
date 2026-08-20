import java.util.*;

public class nextPermutation {

    // Reverse the elements of the array from start to end
    public static void reverseArray(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Find the next lexicographically greater permutation
    public static int[] nextGreaterPermutation(int arr[]) {

        int idx = -1;
        int n = arr.length;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }

        // If no such element exists, the array is the last permutation.
        // Reverse it to get the first permutation.
        if (idx == -1) {
            reverseArray(arr, 0, n - 1);
            return arr;
        }

        // Step 2: Find the smallest element greater than arr[idx]
        // from the right side and swap them
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > arr[idx]) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;

                break;
            }
        }

        // Step 3: Reverse the elements after idx
        // to get the smallest possible permutation
        reverseArray(arr, idx + 1, n - 1);

        return arr;
    }

    public static void main(String[] args) {

        // Sample input
        int arr[] = {1, 2, 3};

        // Find and print the next greater permutation
        System.out.println(
            Arrays.toString(nextGreaterPermutation(arr))
        );
    }
}