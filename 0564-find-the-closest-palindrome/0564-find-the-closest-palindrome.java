class Solution {
    public String nearestPalindromic(String n) {
        if (n.length() == 1) {
            return String.valueOf(Integer.parseInt(n) - 1);
        }

        long number = Long.parseLong(n);

        long numDigits = (long)Math.log10(number);
        List<Long> candidates = new ArrayList<Long>();

        candidates.add(number);
        if (n.length() < 3) {
            candidates.add(new Long(9));
        }
        for (int i = 0; i <= numDigits + 1; i++) {
            candidates.add(number + (long)Math.pow(10, i));
            candidates.add(number - (long)Math.pow(10, i));
        }


        List<Long> palindromes = new ArrayList<Long>();
        for (Long candidate : candidates) {
            if (candidate > 0) {
                long palindrome = getPalindrome(candidate);
                palindromes.add(palindrome);
            }
        }

        long res = Long.MAX_VALUE;
        long maxDistance = Long.MAX_VALUE;
        for (Long palindrome : palindromes) {
            long distance = Math.abs(number - palindrome);
            if (distance < maxDistance && palindrome != number) {
                res = palindrome;
                maxDistance = distance;
            }
            if (distance == maxDistance && palindrome != number) {
                res = Math.min(res, palindrome);
            }
        }

        System.out.println(candidates);
        System.out.println(palindromes);

        return String.valueOf(res);
    }

    private long getPalindrome(long number) {
        String n = String.valueOf(number);
        // Even case
        StringBuilder sb = new StringBuilder();
        if (n.length() % 2 == 0) {
            StringBuilder half = new StringBuilder(n.substring(0, n.length() / 2));
            sb.append(half);
            sb.append(half.reverse());
        }

        //System.out.println(sb.toString());

        // Odd case
        if (n.length() % 2 == 1) {
            StringBuilder half = new StringBuilder(n.substring(0, n.length() / 2));
            sb.append(half);
            sb.append(n.charAt(n.length() / 2));
            sb.append(half.reverse());
        }
        return Long.valueOf(sb.toString());
    } 
}