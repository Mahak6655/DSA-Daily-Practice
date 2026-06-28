
public class numberAppearsOnes {

    // Function to find the element that appears only once
    // All other elements appear exactly twice
    public static int singleNumber(int[] arr) {

        // Initialize result variable
        int ans = 0;

        // Perform XOR operation on all array elements
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
        }

        // The remaining value is the unique element
        return ans;
    }

    public static void main(String[] args) {

        // Sample array where every element appears twice
        // except one element
        int arr[] = {2, 2, 1};

        // Print the element that appears only once
        System.out.println(singleNumber(arr));
    }
}

