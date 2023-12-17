//BRUTE FORce using BFS
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q =new LinkedList<>();
        if(root==null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
             List<Integer> l = new ArrayList<>();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                  if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
               l.add(q.remove().val); 
            }
            res.add(l.get(l.size()-1));
        }
        return res;
    }
}
// DFS

class Solution {
    List<Integer> l = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {     
       rightView(root,0);
       return l;
    }
    public void rightView(TreeNode root,int level){
        if(root==null) return;
        if(level==l.size()) l.add(root.val);
        rightView(root.right,level+1);
        rightView(root.left,level+1);
    }
}
