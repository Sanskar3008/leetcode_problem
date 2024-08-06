class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer>l=new ArrayList<>();

        for(int i=0;i<nums1.length;i++)
        {
            l.add(nums1[i]);
        }
        int []ans=new int[nums2.length];
          int []a=new int[nums1.length];
          Stack<Integer>s=new Stack();
       int k=0;

        for(int i=nums2.length-1;i>=0;i--)
        {
            while(!s.isEmpty()&&s.peek()<=nums2[i])
            {
                s.pop();
            }

            if(s.isEmpty())
            {
                ans[i]=-1;

            }
            else
            {
                ans[i]=s.peek();
            }

            s.push(nums2[i]);

            if(l.contains(nums2[i]))
            {
                 int inx=l.indexOf(nums2[i]);
                 a[inx]=ans[i];
                 k++;
            }
        }
        System.out.println(l);

        return a;
    }
}