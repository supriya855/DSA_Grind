[Question Link] :(https://leetcode.com/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-interview-150)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> l = new ArrayList<>();
    int idx=1;
    public void flatten(TreeNode root) {
        preorder(root);
        buildll(root,l);
    }
    public void preorder(TreeNode root){
        if(root==null) return;
        l.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public void buildll(TreeNode root,List<Integer> l){
        if(root==null) return;
           if(idx<l.size())
           root.right= new TreeNode(l.get(idx++));
           root.left=null;
           buildll(root.right,l);

       }
}
//Summarize:
/*
Undestood the Question: yes
logic:yes
code:yes
Q: We have to flatten the binary as ll 
for this preorder traversal 
and we have to make that preorder traversal as linkedlist that 
evey this should be of right(it said right node should point to next and left should be null)

Approach: I used preorder stored in a list
and to build ll as tree every im creadting new node to treenode of size preorder list and make left as null
just replacing the creating new nodes here

*/
