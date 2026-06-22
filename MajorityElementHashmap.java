

import java.util.*;

public class MajorityElementHashmap {

    public static void main(String[] args) {

        // Input array
        int arr[] = {1, 2};

        // HashMap to store the frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // ---------------- APPROACH 1 ----------------
        // Count frequencies using containsKey()
        /*
        for(int i = 0; i < arr.length; i++) {

            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        Set<Integer> keyset = map.keySet();

        for(Integer k : keyset) {
            if(map.get(k) > arr.length / 3) {
                System.out.print(k + " ");
            }
        }
        */

        // ---------------- APPROACH 2 ----------------
        // Count frequencies using getOrDefault()
        for (int i = 0; i < arr.length; i++) {

            // If key exists, increase count by 1
            // Otherwise, start count from 0 and add 1
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Get all keys from the HashMap
        Set<Integer> keyset = map.keySet();

        // Print elements that appear more than n/3 times
        for (Integer k : keyset) {

            if (map.get(k) > arr.length / 3) {
                System.out.print(k + " ");
            }
        }
    }
}


