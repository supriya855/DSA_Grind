class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildBT(0,postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    public TreeNode buildBT(int postS,int postE,int inS,int inE,int[] inorder,int[] postorder){
        if(postS>postE||inS>inE){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postE]);
        int inIdx=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
            inIdx=i;
            break;
            }
        }
        root.left=buildBT(postS,postS+inIdx-inS-1,inS,inIdx-1,inorder,postorder);
        root.right=buildBT(postS+inIdx-inS,postE-1,inIdx+1,inE,inorder,postorder);
       return root; 
    }
}
//inorder   = [4 2 5 1 6 3 7]
// postorder = [4 5 2 6 7 3 1]
//DRY run with this examples
