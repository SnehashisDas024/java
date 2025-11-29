// Leetcode Problem 1394: find-lucky-integer-in-an-array
// Link: https://leetcode.com/problems/find-lucky-integer-in-an-array/

class Q6 {
    public int findLucky(int[] arr) {
        int[] count = new int[501]; // Since the problem states that 1 <= arr[i] <= 500
        for (int num : arr) {
            count[num]++;
        }
        
        int lucky = -1; // Initialize lucky number as -1
        for (int i = 0; i < count.length; i++) {
            if (count[i] == i) {
                lucky = i; // Update lucky number if condition is met
            }
        }
        
        return lucky; // Return the last found lucky number or -1 if none found
    }
}