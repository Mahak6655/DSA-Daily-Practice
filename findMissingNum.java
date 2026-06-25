
import java.util.*;

public class findMissingNum {

    // Function to find the missing number in an array
    // The array contains numbers from 0 to n with one number missing
    public static int missingNumber(int arr[]) {

        // Length of the array
        int n = arr.length;

        // Calculate the expected sum of numbers from 0 to n
        int Sum = n * (n + 1) / 2;

        // Calculate the actual sum of elements present in the array
        int s2 = 0;

        for (int i = 0; i < arr.length; i++) {
            s2 += arr[i];
        }

        // Missing number = Expected Sum - Actual Sum
        return Sum - s2;
    }

    public static void main(String[] args) {

        // Sample array with one missing number
        int arr[] = {0, 2, 3, 1, 4};

        // Print the missing number
        System.out.println("Misssing num : "+missingNumber(arr));
    }
}
