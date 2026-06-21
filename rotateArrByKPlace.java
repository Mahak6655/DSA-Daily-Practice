
import java.util.Arrays;

public class rotateArrByKPlace {

    // Function to reverse a part of the array
    // It swaps elements from both ends until the range is reversed
    public static int[] reverseArray(int arr[], int start, int end) {

        while (start < end) {

            // Swap the elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return arr;
    }

    // Function to rotate the array to the right by k positions
    public static int[] rightRotateByK(int arr[], int k) {

        int n = arr.length;

        // Handle empty array or zero rotations
        if (n == 0 || k == 0) {
            return arr;
        }

        // If k is greater than array length
        k = k % n;

        // Reverse the entire array
        reverseArray(arr, 0, n - 1);

        // Reverse the first k elements
        reverseArray(arr, 0, k - 1);

        // Reverse the remaining elements
        reverseArray(arr, k, n - 1);

        return arr;
    }

    // Function to rotate the array to the left by k positions
    public static int[] leftRotateByK(int arr[], int k) {

        int n = arr.length;

        // Handle empty array or zero rotations
        if (n == 0 || k == 0) {
            return arr;
        }

        // If k is greater than array length
        k = k % n;

        // Reverse the first k elements
        reverseArray(arr, 0, k - 1);

        // Reverse the remaining elements
        reverseArray(arr, k, n - 1);

        // Reverse the complete array
        reverseArray(arr, 0, n - 1);

        return arr;
    }

    public static void main(String[] args) {

        // Sample array
        int arr[] = {1, 2, 3, 4, 5, 6};

        // Right rotate the array by 2 positions
        System.out.println(Arrays.toString(rightRotateByK(arr, 2)));

        // To test left rotation, use:
        // System.out.println(Arrays.toString(leftRotateByK(arr, 2)));
    }
}

