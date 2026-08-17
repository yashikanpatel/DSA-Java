class Solution {
    public int longestConsecutive(int[] nums) {
         // PATTERN: HashSet
        // Start counting only when current - 1 does NOT exist.
        // This ensures every sequence is counted only once.

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;

        // int maxcount = 0;
        // int count = 0;
        // for(int i =0; i<nums.length-1; i++){
        //     for(int j = i ; j<nums.length; j++){
        //     if(nums[i]==nums[j]+1){
        //         count++;
        //     }
        //     if(count> maxcount){
        //         maxcount = count;
        //     }
        // }
        // }
        // return count;
    }
}