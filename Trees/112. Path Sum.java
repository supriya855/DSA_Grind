class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
       return path(root,0,targetSum);
    }
    public boolean path(TreeNode root,int sum,int targetSum){
        if(root==null) return false;
        if(root.left==null&&root.right==null){
                sum+=root.val;
                if(sum==targetSum){
                    return true;
                }
            }
    return  path(root.left,sum+root.val,targetSum)||path(root.right,sum+root.val,targetSum);

    }
}
// A bit more organized progra
class Solution {
    int sum=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
       if(root==null) return false;
        if(root.left==null&&root.right==null) return targetSum==root.val;
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }

}
