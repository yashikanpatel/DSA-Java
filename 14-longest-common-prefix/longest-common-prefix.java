class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder result = new StringBuilder();

        // i = character position
        for (int i = 0; i < strs[0].length(); i++) {

            // Compare this character with every other string
            for (int j = 1; j < strs.length; j++) {

                // If j-th string is too short OR characters don't match
                if (i >= strs[j].length() ||
                    strs[0].charAt(i) != strs[j].charAt(i)) {

                    return result.toString();
                }
            }

            // This character is common
            result.append(strs[0].charAt(i));
        }

        return result.toString();
    }
}