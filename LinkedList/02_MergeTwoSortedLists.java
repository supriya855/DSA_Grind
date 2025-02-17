Q -1 : we have two lists which are sorted respectively
we need merge them and return the result in sorted way
Ex: 1-> 2-> 4
    1-> 3 -> 4
output : 1-> 1-> 3->4->4

MY first approach was to created a new listnode by comparing values assigning the node values to new listnode

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while(list1!=null && list2!=null){
            if(list1.val==list2.val){
               res.next  = new ListNode(list1.val);
               res = res.next;
               res.next = new ListNode(list2.val);
               list1= list1.next;
               list2= list2.next;
            }
            else if(list1.val < list2.val){
                res.next  = new ListNode(list1.val);
                list1 = list1.next;
               
            }
            else{
                res.next  = new ListNode(list2.val);
                list2 = list2.next;
            }
                           res = res.next;

        }
        if(list1==null) res.next = list2;
        if(list2==null) res.next = list1;

        return ans.next;
    }
}
=================================================================================
//above one can bit optimized like this
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                res.next  = list1;
                list1 = list1.next;
               
            }
            else{
                res.next  = list2;
                list2 = list2.next;
            }
                           res = res.next;

        }
        if(list1==null) res.next = list2;
        if(list2==null) res.next = list1;

        return ans.next;
    }
}
=====================================================================================
better optimized one with TC : O(N) and SC : O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}

