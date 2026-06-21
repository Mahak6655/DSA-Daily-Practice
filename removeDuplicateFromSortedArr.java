
import java.util.*;

public class removeDuplicateFromSortedArr {

    // Function to move unique elements to the beginning of the sorted array
    public static int[] sortedArr(int arr[]) {

        // i points to the last unique element found
        int i = 0;

        // j is used to scan the array
        int j = i + 1;

        while (j <= arr.length - 1) {

            // If a new unique element is found
            if (arr[i] != arr[j]) {

                // Place the unique element next to the previous unique element
                int temp = arr[i + 1];
                arr[i + 1] = arr[j];
                arr[j] = temp;

                // Move i to the newly placed unique element
                i++;
            }

            // Move to the next element
            j++;
        }

        // Return the modified array
        return arr;
    }

    public static void main(String[] args) {

        // Sample sorted array containing duplicate values
        int arr[] = {-2, 2, 4, 4, 4, 4, 5, 5};

        // Print the array after processing
        System.out.println(Arrays.toString(sortedArr(arr)));
    }
}


