class Solution {
    public boolean checkIfExist(int[] arr) {

   Arrays.sort(arr);

   for(int i=0;i<arr.length;i++)
   {
       if(binarysearch(arr,arr[i],i))
       {
           return true;
       }

    
   }
	    return false;
        
    }
    public  boolean binarysearch(int []arr,int target,int i)
	{
		int start=0;
		int end=arr.length-1;
		
		while (start<=end)
		{
			
			int mid =start+(end-start)/2;//same (start+end)/2
			
			if(target>arr[mid]*2)
			{
				start=mid+1;
			}
			else if(target<arr[mid]*2)
			{
				end=mid-1;
			}
			else
			{
				if(i!=mid)
				return true;
				else
				start++;
			
			}
			
		}
		
		return false;
	}
}