class Solution {
    public boolean rotateString(String s, String t) {
    
		 if(s.length()!=t.length())
		 return false;
    	  s=s+s;
    	 if(s.contains(t))
    	 {
    		
    		 return true;
    	 }
    	 
            return false;
    	 
        
    }
}