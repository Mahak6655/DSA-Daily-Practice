import java.util.*;

public class rearrangeElementBySign {

    // Brute Force Approach
    // Store positive and negative elements separately
    // and then place them alternately in the array
    public static int[] rearrangeElementBySignBrute(int arr[]) {

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Separate positive and negative elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }

        // Place positive elements at even indices
        // and negative elements at odd indices
        for (int i = 0; i < arr.length / 2; i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }

        return arr;
    }

    // Optimal Approach
    // Directly place positive elements at even indices
    // and negative elements at odd indices
    public static int[] rearrangeElementBySignOptimal(int arr[]) {

        int posIdx = 0;
        int negIdx = 1;

        // Create a new array to store the rearranged elements
        int ans[] = new int[arr.length];

        // Traverse the original array
        for (int i = 0; i < arr.length; i++) {

            // Place negative elements at odd indices
            if (arr[i] < 0) {
                ans[negIdx] = arr[i];
                negIdx += 2;
            }

            // Place positive elements at even indices
            else {
                ans[posIdx] = arr[i];
                posIdx += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        // Sample input
        int arr[] = {1, 2, -4, -5};

        // Rearrange the array by sign
        System.out.println(
            Arrays.toString(rearrangeElementBySignOptimal(arr))
        );
    }
}
