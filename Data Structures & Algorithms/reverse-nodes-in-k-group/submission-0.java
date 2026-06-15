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
    public ListNode reverseKGroup(ListNode head, int k) {
        System.out.println(head!=null? head.val:-1);
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = head;
        int cn = 0;
        while(dummy!=null){
            cn++;
            System.out.println(cn+"ff "+k);
            if(cn==k){
                break;
            }
            dummy=dummy.next;
        }
        if(cn<k){
            return head;
        }
        int cnt=1;
        ListNode p=head,q=head.next,r=head.next.next;
        while(cnt<k && q!=null){
            cnt++;
            q.next = p;
            p=q;
            q=r;
            if(r!=null){
                r=r.next;
            }
        }
        head.next = reverseKGroup(q,k);
        return p;
    }
}
