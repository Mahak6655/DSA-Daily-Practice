
import java.util.*;

public class uniounOfArray {

    // Function to find and display the union of two arrays
    public static void unionOfElement(int arr1[], int arr2[]) {

        // HashSet stores only unique elements
        HashSet<Integer> hs = new HashSet<>();

        // Add all elements of the first array
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }

        // Add all elements of the second array
        // Duplicate elements are ignored automatically
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }

        // Print all unique elements from both arrays
        System.out.print("Union Elements : " + hs);
    }

    public static void main(String[] args) {

        // Sample arrays
        int arr1[] = {3, 4, 6, 7, 9, 9};
        int arr2[] = {1, 5, 7, 8, 8};

        // Display the union of both arrays
        unionOfElement(arr1, arr2);
    }
}

