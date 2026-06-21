
import java.util.Arrays;

public class rotateArrByOne {

    // Function to rotate the array by one position to the left
    public static int[] rotateArray(int arr[]) {

        // Store the first element because it will be overwritten
        int first = arr[0];

        // Shift all elements one position to the left
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        // Place the first element at the last position
        arr[arr.length - 1] = first;

        // Return the rotated array
        return arr;
    }

    public static void main(String[] args) {

        // Sample array
        int arr[] = {1, 2, 3, 4, 5};

        // Print the array after rotation
        System.out.println(Arrays.toString(rotateArray(arr)));
    }
}

