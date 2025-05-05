https://www.techinterviewhandbook.org/grind75/?order=topics
Intial brute force was to have stack
store and pop the values assign it to our original LL
------------------------------------------------------------

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
    public ListNode reverseList(ListNode head) {
     ListNode curr = head, prev = null;
     while(curr!=null){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

     }
     return prev;
    }
}
