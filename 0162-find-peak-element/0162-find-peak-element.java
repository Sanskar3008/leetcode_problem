class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

       
        // if (n == 1) return 0;
        // if (n == 2) return nums[0] > nums[1] ? 0 : 1;

        int s = 0;
        int e = n - 1;

        while (s < e) {
            int m = s + (e - s) / 2;

            
            if ((m == 0 || nums[m] > nums[m - 1]) && (m == n - 1 || nums[m] > nums[m + 1])) {
                return m;
            } 
          
            else if (nums[m] > nums[m + 1]) {
                e = m;
            } 
            else {
                s = m + 1;
            }
        }

        
        return s;
    }
}