class Solution {
    public int countSubstrings(String s) {
        List<String>h=new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
            isPal(s,i,i,h);
            if(i+1!=s.length())
            isPal(s,i,i+1,h);
        }

        return h.size();
    }

    public void isPal(String s,int i,int j,List h)
    {

        while((i>=0 &&j<s.length())&&(s.charAt(i)==s.charAt(j)))
        {
            h.add(s.substring(i,j+1));
            i--;
            j++;
        }
    }
}