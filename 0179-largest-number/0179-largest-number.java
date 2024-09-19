class Solution {
    public class SortByString implements Comparator<String> {
       public int compare(String a, String b) {
            return (b + a).compareTo(a + b);
        }
    }
    public String largestNumber(int[] nums) {
        String [] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            str[i] = nums[i] + "";
        }
        Arrays.sort(str, new SortByString());
        if(Integer.parseInt(str[0]) == 0){
            return "0";
        }
        String ans = "";
        for(String val: str){
            ans+=val;
        }
        return ans;
    }
}