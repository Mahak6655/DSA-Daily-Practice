public class practice2 {

    // Method to check whether the array is sorted in ascending order
    public static boolean arrayIsSorted(int arr[]) {

        // Traverse the array and compare each element with the next element
        for (int i = 0; i < arr.length - 1; i++) {

            // If the current element is greater than the next element,
            // the array is not sorted
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        // If no unsorted pair is found, the array is sorted
        return true;
    }

    public static void main(String[] args) {

        // Sample array
        int arr[] = {1, 2, 1, 3, 4, 5};

        // Display whether the array is sorted or not
        System.out.println("Is the array sorted? :- " + arrayIsSorted(arr));
    }
}