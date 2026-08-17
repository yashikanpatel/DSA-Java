class Solution {
    public int removeDuplicates(int[] nums) {

        // PATTERN: Two Pointers
        // i = position of last unique element
        // j = scans the array

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
        
    }
}
/* // PATTERN: Boyer-Moore Voting Algorithm
        // Different elements cancel each other.
        
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate; */