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
********************************************************************************************************
class Solution {
    int max=0;
    public int maxAncestorDiff(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        path(root,list);
        return max;
    }
    public void path(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        if(root.left==null&&root.right==null){
            for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                max=Math.max(max,(int)Math.abs(list.get(i)-list.get(j)));
            }
        }
        }
        path(root.left,list);
        path(root.right,list);
        list.remove(list.size()-1);
    } 
}
