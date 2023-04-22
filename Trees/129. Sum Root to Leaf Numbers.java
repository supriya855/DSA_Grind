class Solution {
    int ans=0;
    public int sumNumbers(TreeNode root) {
        int val=0;
        sumRootToLeaf(root,0);
        return ans;
    }
    public void sumRootToLeaf(TreeNode root,int val){
        if(root==null) return;
        val*=10;
        val+=root.val;
        if(root.left==null&&root.right==null){
            ans+=val;
            return;
        }
        sumRootToLeaf(root.left,val);
        sumRootToLeaf(root.right,val);
    }
}
**************************************************
class Solution {
    public int sumNumbers(TreeNode root) {
       return  sum(root,0);
    }
    public int sum(TreeNode root,int val){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return val*10+root.val;
        return sum(root.left,val*10+root.val)+sum(root.right,val*10+root.val);
    }
}
