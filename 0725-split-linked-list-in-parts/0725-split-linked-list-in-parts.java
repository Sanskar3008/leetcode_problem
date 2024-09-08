/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode []ans=new ListNode[k];
        int size=0;
        ListNode temp=head;
        while(temp!=null)
        {
          temp=temp.next;
          size++;

        }
       
temp=head;
        if(k>size)
        { int i=0;
            while(temp!=null)
            {
                ListNode nex=temp.next;
                ans[i]=temp;
                temp.next=null;
                temp=nex;
                i++;
            }
        }
        else
        {
            int i=0;
            int it=size/k;
            int rem=size%k;
            while(k!=0)
            {
                int  a=it-1;
                if(rem!=0)
                {
                    a++;
                    rem--;
                }
                ans[i]=temp;
                while(a!=0){
                    //if(temp!=null)
                    temp=temp.next;
                    System.out.println(it);
                    a--;
                    
                  
                }
                 // if(temp!=null)
                   ListNode nex=temp.next;
                 temp.next=null;
                temp=nex;
                i++;
                k--;
            }
        }
        return ans;
    }
}