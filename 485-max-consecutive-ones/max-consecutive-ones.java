class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       // PATTERN: Single Pass
        // count = current consecutive 1s
        // max = maximum consecutive 1s found

        int count = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        return max;


    
        
    }
}