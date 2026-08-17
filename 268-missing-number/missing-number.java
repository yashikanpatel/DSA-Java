class Solution {
    public int missingNumber(int[] nums) {
        // PATTERN: XOR
        // Same numbers cancel each other: x ^ x = 0

        int xor = nums.length;

        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor;  
    }
}