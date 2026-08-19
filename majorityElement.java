import java.util.*;

public class majorityElement {

    // Brute Force Approach
    // Count the frequency of every element using nested loops
    public static int majorityElementBrute(int arr[]) {

        // Pick each element one by one
        for (int i = 0; i < arr.length; i++) {

            int cnt = 0;

            // Count how many times arr[i] appears
            for (int j = 0; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    cnt++;
                }

                // If frequency is greater than n/2,
                // it is the majority element
                if (cnt > arr.length / 2) {
                    return arr[i];
                }
            }
        }

        // No majority element found
        return -1;
    }

    // Better Approach using HashMap
    // Store the frequency of every element
    public static int majorityElementBetter(int arr[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check whether any element occurs more than n/2 times
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > arr.length / 2) {
                return entry.getKey();
            }
        }

        // No majority element found
        return -1;
    }

    // Optimal Approach using Moore's Voting Algorithm
    public static int majorityElementOptimal(int arr[]) {

        int cnt = 0;
        int el = 0;

        // Find the potential majority element
        for (int i = 0; i < arr.length; i++) {

            // If count becomes zero, select a new candidate
            if (cnt == 0) {
                cnt = 1;
                el = arr[i];
            }

            // Same element increases the count
            else if (arr[i] == el) {
                cnt++;
            }

            // Different element cancels out one occurrence
            else {
                cnt--;
            }
        }

        // Verify whether the candidate is actually
        // present more than n/2 times
        int cnt1 = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == el) {
                cnt1++;
            }
        }

        // Return the candidate only if it is actually
        // a majority element
        if (cnt1 > arr.length / 2) {
            return el;
        }

        return -1;
    }

    public static void main(String[] args) {

        // Sample input
        int arr[] = {2, 2, 3, 3, 1, 2, 2};

        // Find and print the majority element
        System.out.println(majorityElementOptimal(arr));
    }
}