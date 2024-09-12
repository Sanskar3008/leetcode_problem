class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        boolean[] allowedChars = new boolean[26];
        Arrays.fill(allowedChars, false);
        for (char c : allowed.toCharArray()) {
            allowedChars[c - 'a'] = true;
        }

        for (String s : words) {
            if (isConsistant(s, allowedChars)) {
                count++;
            }
        }

        return count;
    }

    boolean isConsistant(String s, boolean[] allowed) {
        for (char c : s.toCharArray()) {
            if (!allowed[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}