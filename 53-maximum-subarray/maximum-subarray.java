class Solution {
    public int maxSubArray(int[] nums) {


        // PATTERN: Kadane's Algorithm
        // Keep a running sum and reset it when it becomes harmful.

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
       
}