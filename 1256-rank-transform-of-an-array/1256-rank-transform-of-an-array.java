class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int ans []=arr.clone();
        Arrays.sort(arr);

        if(arr.length==0)
        return arr;

        Map<Integer, Integer>m=new HashMap<>();	

        int prev=arr[0];
        int rank=1;
        m.put(arr[0],rank);

        for (int i=1;i<arr.length;i++)
        {
            if(arr[i]!=prev)
            {
                rank++;
                m.put(arr[i],rank);
                prev=arr[i];
            }
        }
        System.out.println(m);

        for (int i=0;i<ans.length;i++)
        {
            ans[i]=m.get(ans[i]);
        }

        return ans;
       
}
}