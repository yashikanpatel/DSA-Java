class Solution {
    public int[] productExceptSelf(int[] nums) {
        // PATTERN: Prefix + Suffix
        // ans[i] first stores product of elements on the left.
        // Then multiply by a running suffix product.

        int n = nums.length;
        int[] ans = new int[n];

        // Prefix product
        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Suffix product
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * suffix;
            suffix = suffix * nums[i];
        }

        return ans;
    }
}