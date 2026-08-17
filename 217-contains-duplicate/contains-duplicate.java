class Solution {
    public boolean containsDuplicate(int[] nums) {
        // PATTERN: HashSet
        // If an element is already present, it is a duplicate.

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}