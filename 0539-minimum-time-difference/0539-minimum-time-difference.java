class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> mins = new ArrayList<>();
        int ans = Integer.MAX_VALUE;
        
        for(String time: timePoints){
            String[] t = time.split(":");
            int hour = Integer.parseInt(t[0]);
            int min = Integer.parseInt(t[1]);
            mins.add((hour*60)+min);
        }
        Collections.sort(mins);
        
        for(int i =1;i<mins.size(); i++){
            ans = Math.min(ans, mins.get(i)-mins.get(i-1));
        }

        ans = Math.min(ans, 24*60-(mins.get(mins.size()-1)-mins.get(0)));

        return ans;
    }
}