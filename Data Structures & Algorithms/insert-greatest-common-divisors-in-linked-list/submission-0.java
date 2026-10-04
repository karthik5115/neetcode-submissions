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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        if(cur.next==null){
            return cur;
        }
        while(cur.next!=null){
            ListNode l1 = cur, l2 = cur.next;
            int gcdValue = findGCD(l1.val,l2.val);
            ListNode gcdNode = new ListNode(gcdValue);
            gcdNode.next = cur.next;
            cur.next = gcdNode;
            cur=gcdNode.next;

        }
        return head;
        
    }
    public int findGCD(int a,int b){
         while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}