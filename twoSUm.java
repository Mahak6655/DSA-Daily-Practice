import java.util.Arrays;
import java.util.HashMap;

public class twoSUm {

    // Brute Force Approach
    // Check every possible pair to find two elements
    // whose sum is equal to the target
    public static void twoSumBrute(int arr[], int t) {

        // Select the first element
        for (int i = 0; i < arr.length; i++) {

            // Select the second element
            for (int j = i + 1; j < arr.length; j++) {

                // Check whether the pair adds up to the target
                if (arr[i] + arr[j] == t) {
                    System.out.println("indices are : {" + i + "," + j + "}");
                    return;
                }
            }
        }

        // No pair found
        System.out.println("not found");
    }

    // Better Approach using HashMap
    // Stores previously visited elements and their indices
    public static int[] twoSumBetter(int arr[], int t) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Find the value required to reach the target
            int complement = t - arr[i];

            // If complement already exists, we found the pair
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store the current element and its index
            map.put(arr[i], i);
        }

        // Return {-1, -1} if no pair is found
        return new int[]{-1, -1};
    }

    // Optimal Approach using Two Pointers
    // Original indices are not preserved because sorting changes
    // the positions of the elements
    public static int[] twoSumOptimal(int arr[], int t) {

        // Sort the array first
        Arrays.sort(arr);

        int l = 0;
        int r = arr.length - 1;

        // Use two pointers to find the target sum
        while (l < r) {

            int sum = arr[l] + arr[r];

            // Target found
            if (sum == t) {
                return new int[]{l, r};
            }

            // Increase left pointer if sum is smaller
            else if (sum < t) {
                l++;
            }

            // Decrease right pointer if sum is greater
            else {
                r--;
            }
        }

        // Return {-1, -1} if no pair is found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        // Sample array
        int arr[] = {2, 6, 5, 8, 11};

        // Find two elements whose sum is 14
        System.out.println(Arrays.toString(twoSumOptimal(arr, 14)));
    }
}