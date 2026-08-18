import java.util.Arrays;

public class sort0s1s2s {

    // Better Approach:
    // Count the number of 0s, 1s, and 2s and then
    // overwrite the array using those counts
    public static int[] sortAnArray(int arr[]) {

        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        // Count occurrences of 0, 1, and 2
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cnt0++;
            } else if (arr[i] == 1) {
                cnt1++;
            } else {
                cnt2++;
            }
        }

        // Fill the array with 0s
        for (int i = 0; i < cnt0; i++) {
            arr[i] = 0;
        }

        // Fill the array with 1s
        for (int i = cnt0; i < cnt0 + cnt1; i++) {
            arr[i] = 1;
        }

        // Fill the remaining positions with 2s
        for (int i = cnt0 + cnt1; i < arr.length; i++) {
            arr[i] = 2;
        }

        return arr;
    }

    // Optimal Approach:
    // Dutch National Flag Algorithm
    public static int[] sortAnArrayOptimal(int arr[]) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        // Process the array until mid crosses high
        while (mid <= high) {

            // If current element is 0,
            // move it to the low region
            if (arr[mid] == 0) {

                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;

                low++;
                mid++;
            }

            // If current element is 1,
            // it is already in its correct region
            else if (arr[mid] == 1) {
                mid++;
            }

            // If current element is 2,
            // move it to the high region
            else {

                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;

                // Do not increment mid here because
                // the swapped element needs to be checked
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        // Sample input
        int arr[] = {0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        // Sort the array using Dutch National Flag Algorithm
        System.out.println(Arrays.toString(sortAnArrayOptimal(arr)));
    }
}