class Solution {
    private void prefixAdd(int num, Map<String, Integer> preFixCountMap) {
        String s = String.valueOf(num);
        for (int i = 0; i <= s.length(); i++) {
            String s2 = s.substring(0, i);
            preFixCountMap.put(s2, 1);
        }
    }

    private int prefixFinder(int num, Map<String, Integer> preFixCountMap) {
        String s = String.valueOf(num);
        int maxPreFix = 0;
        for (int i = 0; i <= s.length(); i++) {
            String s2 = s.substring(0, i);
            if (preFixCountMap.get(s2) != null) {
                maxPreFix = Math.max(maxPreFix, s2.length());
            }
        }
        return maxPreFix;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Map<String, Integer> preFixCountMap = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            prefixAdd(arr1[i], preFixCountMap);
        }

        int maxPreFix = 0;
        for (int i = 0; i < arr2.length; i++) {
            maxPreFix = Math.max(maxPreFix, prefixFinder(arr2[i], preFixCountMap));
        }

        return maxPreFix;
    }
}