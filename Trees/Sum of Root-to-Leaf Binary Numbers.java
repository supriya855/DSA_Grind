class Solution {
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
       path(root,0);
       return sum;  
    }
    public void path(TreeNode root,int currNum){
        if(root!=null){
            currNum =currNum*2+root.val;
            if(root.left==null&&root.right==null){
                sum+=currNum;
            }
            path(root.left,currNum);
            path(root.right,currNum);
        }
    }
}
