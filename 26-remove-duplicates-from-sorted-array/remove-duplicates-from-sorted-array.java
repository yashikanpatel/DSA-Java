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