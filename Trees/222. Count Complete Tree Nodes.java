class Solution {
    int count=0;
    public int countNodes(TreeNode root) {
       helper(root);
       return count;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        count++;
        helper(root.left);
        helper(root.right);
    }
}
//This can also done using level and count the nodes
