class Solution {
    // This is the top-down approach
    //Using depth/height of a BT
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int l=height(root.left);
        int r=height(root.right);
       return Math.abs(l-r)<=1&&isBalanced(root.left)&&isBalanced(root.right);   
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        int left =height(root.left);
        int right=height(root.right);
        return 1+Math.max(left,right);
    }
}
