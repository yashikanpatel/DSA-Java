class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // 1. Check if a palindromic permutation is possible
        int oddCount = 0;
        char midChar = '\0'; // The character for the middle (if n is odd)
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }

        // If n is even, all counts must be even.
        // If n is odd, exactly one count must be odd.
        if ((n % 2 == 0 && oddCount > 0) || (n % 2 != 0 && oddCount > 1)) {
            return ""; // Not possible to form a palindrome
        }

        // 2. Create frequency map for the first half
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int k = n / 2; // Length of the first half
        
        // 3. Backtrack to find the smallest "first half"
        //    that is greater than or equal to target's first half
        String result = findSmallestHalf(target, 0, k, false, halfFreq, new StringBuilder(), midChar, n);
        
        return result == null ? "" : result;
    }

    /**
     * Recursive function to find the lexicographically smallest first-half
     * that can form a palindrome strictly greater than target.
     *
     * @param target    The target string
     * @param index     Current index we are building in the first half
     * @param k         Total length of the first half (n / 2)
     * @param isGreater Flag: is our prefix already lexicographically greater than target's prefix?
     * @param halfFreq  Available characters for the first half
     * @param sb        The current first-half prefix being built
     * @param midChar   The middle character (or '\0' if n is even)
     * @param n         The total length of the string
     * @return The resulting palindrome string, or null if no solution found
     */
    private String findSmallestHalf(String target, int index, int k, boolean isGreater, 
                                    int[] halfFreq, StringBuilder sb, char midChar, int n) {
        
        // Base Case: We have successfully built the entire first half (length k)
        if (index == k) {
            String prefix = sb.toString();
            String palindrome = buildPalindrome(prefix, midChar, n);

            // If we are here, our prefix was not strictly greater (isGreater=false),
            // it was equal. We must check if the constructed palindrome is
            // *actually* greater than the target (e.g., "ba" -> "baab" vs "baaa")
            if (palindrome.compareTo(target) > 0) {
                return palindrome;
            }
            return null; // This palindrome was <= target (e.g., "abba" vs "abba")
        }

        // Recursive Step
        char targetChar = target.charAt(index);

        // Try all possible characters from 'a' to 'z'
        for (int i = 0; i < 26; i++) {
            if (halfFreq[i] <= 0) continue; // No more of this char available

            char c = (char) ('a' + i);

            // If we are not yet greater, we cannot pick a char smaller than target's char
            if (!isGreater && c < targetChar) {
                continue;
            }

            // --- Try this character ---
            halfFreq[i]--;
            sb.append(c);

            boolean newIsGreater = isGreater || (c > targetChar);
            String result = null;

            if (newIsGreater) {
                // **Greedy Completion**
                // We've become greater than target. To find the *smallest*
                // result, just append all remaining chars in alphabetical order.
                StringBuilder tempSb = new StringBuilder(sb.toString());
                for (int j = 0; j < 26; j++) {
                    for (int l = 0; l < halfFreq[j]; l++) {
                        tempSb.append((char) ('a' + j));
                    }
                }
                result = buildPalindrome(tempSb.toString(), midChar, n);
                
            } else {
                // We are still "tied" (c == targetChar). Recurse.
                result = findSmallestHalf(target, index + 1, k, false, halfFreq, sb, midChar, n);
            }

            // --- Backtrack ---
            sb.deleteCharAt(sb.length() - 1);
            halfFreq[i]++;

            // If the recursive call (or greedy completion) found a solution,
            // propagate it up. This ensures we return the *first* one we find,
            // which is the lexicographically smallest.
            if (result != null) {
                return result;
            }
        }

        return null; // No character worked at this index
    }

    /** Helper to construct the full palindrome from its parts. */
    private String buildPalindrome(String prefix, char midChar, int n) {
        StringBuilder suffix = new StringBuilder(prefix).reverse();
        if (n % 2 == 0) {
            return prefix + suffix;
        } else {
            return prefix + midChar + suffix;
        }
    }
}