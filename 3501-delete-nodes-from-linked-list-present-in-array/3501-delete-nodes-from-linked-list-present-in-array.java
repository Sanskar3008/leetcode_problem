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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for(int x : nums) hs.add(x);
        return rec(hs,head);
    }
    public ListNode rec(HashSet<Integer> hs , ListNode head){
        if(head==null) return null;
        if(hs.contains(head.val)){
            return rec(hs,head.next);
        }
        head.next=rec(hs,head.next);
        return head;
    }
}