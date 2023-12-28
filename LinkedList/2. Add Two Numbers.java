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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res= new ListNode(0);
        ListNode ans=res;
        int div=0,sum=0;
        while(l1!=null&&l2!=null){
           sum=l1.val+l2.val+div;
            if(sum<10){
                res.next = new ListNode(sum);
                div=0;
            }
            else{
                int rem=sum%10;
                 div=sum/10;
                res.next = new ListNode(rem);
            }
            l1=l1.next;
            l2=l2.next;
            res=res.next;
        }
        while(l1!=null){
            sum=l1.val+div;
            if(sum<10){
                res.next = new ListNode(sum);
                div=0;
            }
            else{
                int rem=sum%10;
                 div=sum/10;
                res.next = new ListNode(rem);
            }
            l1=l1.next;
              res=res.next;
        }
        while(l2!=null){
            sum=l2.val+div;
            if(sum<10){
                res.next = new ListNode(sum);
                div=0;
            }
            else{
                int rem=sum%10;
                 div=sum/10;
                res.next = new ListNode(rem);
            }
            l2=l2.next;
            res=res.next;
        }
        if(div!=0){
            res.next = new ListNode(div);
            res=res.next;
        }
        
        return ans.next;
    }
}
