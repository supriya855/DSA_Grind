//Using Recursion
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        return p.val==q.val&&isSameTree(p.left, q.left) &&isSameTree(p.right, q.right);
    }
}
-------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------
//using iteration
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack_p = new Stack<>();
        Stack<TreeNode> stack_q = new Stack<>();
        if(p==null&&q==null) return true;
      if (p == null && q != null || p != null && q == null) return false;
        stack_p.push(p);
        stack_q.push(q);
        while(!stack_p.isEmpty()&&!stack_q.isEmpty()){
            TreeNode popP= stack_p.pop();
            TreeNode popQ=stack_q.pop();
            if(popP.val!=popQ.val) return false;
            if(popP.left!=null&&popQ.left!=null){
                stack_p.push(popP.left);
                stack_q.push(popQ.left);
            }
           else if(popP.left==null&&popQ.left==null) {

           }
           else return false;
             if(popP.right!=null&&popQ.right!=null){
                stack_p.push(popP.right);
                stack_q.push(popQ.right);
            }
             else if(popP.right==null&&popQ.right==null) {// this for when both rights are null but lefts are not 

             }
             else return false;
        }
            if(!stack_p.isEmpty()||!stack_q.isEmpty()){
                return false;
            }
        
        return true;

    }
}
