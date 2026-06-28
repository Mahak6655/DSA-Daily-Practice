
public class maxConswcutiveOnes {

    // Function to find the maximum number of consecutive 1's in an array
    public static int findMaxConsecutiveOnes(int[] nums) {

        // Stores the maximum count of consecutive 1's found so far
        int ans = 0;

        // Stores the current count of consecutive 1's
        int count = 0;

        // Traverse each element of the array
        for (int num : nums) {

            // If the current element is 1, increase the count
            if (num == 1) {
                count++;
            } else {

                // Update the maximum count when a 0 is encountered
                ans = Math.max(ans, count);

                // Reset the count for the next sequence of 1's
                count = 0;
            }
        }

        // Final update in case the array ends with 1's
        ans = Math.max(ans, count);

        return ans;
    }

    public static void main(String[] args) {

        // Sample binary array
        int nums[] = {1, 1, 0, 0, 1, 1, 1, 0};

        // Print the maximum consecutive 1's
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}

