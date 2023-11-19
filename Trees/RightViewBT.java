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
