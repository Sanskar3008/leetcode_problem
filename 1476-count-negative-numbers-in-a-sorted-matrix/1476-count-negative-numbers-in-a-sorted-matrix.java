class Solution {
    public int countNegatives(int[][] arr) {
        int c=0;
        for (int i=0;i<arr.length;i++)
        {
           c=c+count(arr[i]);
        }
        
        return c;

        
    }

    public int count (int []arr)
    {
        int start=0;
        int end=arr.length-1;
        if(arr[arr.length-1]>=0)
        {
              System.out.println("a");
                return 0;
              
        }

        while(start<end)
        {
            

            int mid=start+(end-start)/2;
        

            if(arr[mid] >= 0)
            {
                start=mid+1;
            }
          else if (arr[mid] < 0 )
            {
                end=mid;
            }
            else
            {
                return arr.length-mid;
            }
        }
        
          return arr.length- start;

        
        
    }
}