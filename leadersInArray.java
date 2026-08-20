import java.util.*;

public class leadersInArray {

    // Brute Force Approach
    // An element is a leader if all elements to its right
    // are smaller than it
    public static ArrayList<Integer> leaderInArrayBrute(int arr[]) {

        ArrayList<Integer> al = new ArrayList<>();

        // Check every element
        for (int i = 0; i < arr.length; i++) {

            boolean leader = true;

            // Compare the current element with all elements
            // on its right side
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] >= arr[i]) {
                    leader = false;
                    break;
                }
            }

            // Add the element if it is a leader
            if (leader) {
                al.add(arr[i]);
            }
        }

        return al;
    }

    // Better Approach
    // Traverse from right to left while keeping track
    // of the maximum element seen so far
    public static ArrayList<Integer> leaderInArrayBetter(int arr[]) {

        ArrayList<Integer> al = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        // Traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {

            // If current element is greater than all elements
            // seen on its right, it is a leader
            if (arr[i] > max) {
                al.add(arr[i]);
            }

            // Update the maximum element
            max = Math.max(max, arr[i]);
        }

        // Leaders were collected from right to left,
        // so reverse them to restore original order
        Collections.reverse(al);

        return al;
    }

    public static void main(String[] args) {

        // Sample input
        int[] arr = {1, 2, 5, 3, 1, 2};

        // Find and print all leaders
        System.out.println(leaderInArrayBetter(arr));
    }
}