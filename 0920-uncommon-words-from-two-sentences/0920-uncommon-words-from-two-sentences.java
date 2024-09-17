class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // HashSet<String> set = new HashSet<>();
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        // int m = 0;
        // for(String i : arr){
        //     set.add(i);
        //     if(m == set.size()) set.remove(i);
        //     m = set.size();
        // }
        // int k = set.size();
        // for(String i : arr1){
        //     set.add(i);
        //     if(k == set.size()) set.remove(i);
        //     k = set.size();
        // }
        //  String[] result = set.toArray(new String[0]);
        // return result;
        HashSet<String>set = new HashSet<>();
        
        ArrayList<String> result = new ArrayList<>();
        for(String i:arr1) result.add(i);
        for(String i:arr2) result.add(i);
        
        for(int i = 0;i<result.size();i++){
            int count = 0;
            for(int j =0;j<result.size();j++){
                if(i!=j){
                    if(result.get(i).equals(result.get(j))) count++;
                }
            }
            if(count == 0){
                set.add(result.get(i));
            }
        }
        String[] fin = new String[set.size()];
        int j  =0;
        for(String i:set){
            fin[j] = i;
            j++;
        }
        return fin;
    }
}