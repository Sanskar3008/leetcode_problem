import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Initialize the maximum frequency required for each character
        int[] maxFrequencies = new int[26]; // For letters 'a' to 'z'
        Set<Integer> lettersNeeded = new HashSet<>(); // Track letters needed

        // Compute maximum frequencies from words2
        for (String word : words2) {
            int[] wordFrequencies = countFrequencies(word);
            for (int i = 0; i < 26; i++) {
                if (wordFrequencies[i] > maxFrequencies[i]) {
                    maxFrequencies[i] = wordFrequencies[i];
                    lettersNeeded.add(i);
                }
            }
        }

        // Convert lettersNeeded to a list for faster iteration
        List<Integer> lettersNeededList = new ArrayList<>(lettersNeeded);

        // List to store universal words
        List<String> universalWords = new ArrayList<>();

        // Check each word in words1
        for (String word : words1) {
            int[] wordFrequencies = countFrequencies(word);
            boolean isUniversal = true;
            for (int i : lettersNeededList) {
                if (wordFrequencies[i] < maxFrequencies[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                universalWords.add(word);
            }
        }

        return universalWords;
    }

    // Function to count character frequencies in a word
    private int[] countFrequencies(String word) {
        int[] frequencies = new int[26];
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            frequencies[idx]++;
        }
        return frequencies;
    }
}