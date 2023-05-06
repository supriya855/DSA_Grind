class Solution {
    public int maxAncestorDiff(TreeNode root) {
       return dfs(root,root.val,root.val);
    }
    public int dfs(TreeNode root,int mini,int maxi){
        if(root==null) return maxi-mini;
        mini=Math.min(mini,root.val);
        maxi=Math.max(maxi,root.val);
        return Math.max(dfs(root.left,mini,maxi),dfs(root.right,mini,maxi));
    }
}
// while traversing recursively from root to leaf we are finding max and min values of root 
