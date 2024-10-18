class Solution {
    public int or(List<Integer> ds){
        int o=ds.get(0);
        for(int i: ds){
            o=o|i;
        }
        return o;
    }
    public void back(int[] nums, List<Integer> ans, List<Integer> ds, int ind){
        if(ind==nums.length){
            if(ds.size()==0) return;
            ans.add(or(ds));
            return;
        }
        ds.add(nums[ind]);
        back(nums, ans, ds, ind+1);
        ds.remove(ds.size()-1);
        back(nums, ans, ds, ind+1);
    }
    public int countMaxOrSubsets(int[] nums) {
        List<Integer> ans= new ArrayList<>();
        back(nums, ans, new ArrayList<>(), 0);
        return Collections.frequency(ans, Collections.max(ans));
    }
}