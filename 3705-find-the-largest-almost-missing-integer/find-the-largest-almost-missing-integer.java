class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        // Case 1: k == n
        if (k == n) {
            int max = nums[0];

            for (int num : nums) {
                max = Math.max(max, num);
            }

            return max;
        }

        // Count frequency of every number
        int[] count = new int[51];

        for (int num : nums) {
            count[num]++;
        }

        // Case 2: k == 1
        if (k == 1) {
            int ans = -1;

            for (int num : nums) {
                if (count[num] == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        // Case 3: 1 < k < n
        int ans = -1;

        if (count[nums[0]] == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (count[nums[n - 1]] == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}