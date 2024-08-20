class Solution {
    public void isPal(String s, int i, int j, StringBuilder max) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if (max.length() < (j - i + 1)) {
                max.setLength(0); // Clear the StringBuilder
                max.append(s.substring(i, j + 1)); // Add the new longest palindrome
            }
            i--;
            j++;
        }
    }

    public String longestPalindrome(String s) {
        StringBuilder max = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            isPal(s, i, i, max); // Odd-length palindromes
            if (i + 1 < s.length()) {
                isPal(s, i, i + 1, max); // Even-length palindromes
            }
        }
        return max.toString();
    }
}
