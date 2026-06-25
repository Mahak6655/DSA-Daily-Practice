
import java.util.Arrays;

public class moveZeroAtEnd {

    // Function to move all zeroes to the end of the array
    // while maintaining the relative order of non-zero elements
    public static int[] moveZero(int arr[]) {

        // Find the index of the first zero
        int j = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero is found, return the original array
        if (j == -1)
            return arr;

        // Traverse the remaining elements
        for (int i = j + 1; i < arr.length; i++) {

            // If a non-zero element is found
            if (arr[i] != 0) {

                // Swap it with the zero at index j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                // Move j to the next zero position
                j++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        // Sample array containing zero and non-zero elements
        int arr[] = {0, 1, 4, 0, 5, 2};

        // Print the array after moving all zeroes to the end
        System.out.println(Arrays.toString(moveZero(arr)));
    }
}

