/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length-1,preorder,inorder);
    }
    public TreeNode helper(int preStart,int inStart, int inEnd,int[] preorder,int[] inorder){
        if(preStart>preorder.length||inStart>inEnd){
            return null;
        }
        TreeNode root= new TreeNode(preorder[preStart]);
        int inIdx=0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==root.val)
                inIdx=i;
        }
        root.left=helper(preStart+1,inStart,inIdx-1,preorder,inorder);// from inorder start point to the root index in inorder -1
        root.right= helper(preStart+inIdx-inStart+1,inIdx+1,inEnd,preorder,inorder);//preStart+inIdx-inStart+1 => this is mainly due we are skipping what ever the left nodes(inIdx-inStart) from this will get the no.of of Left nodes from inorder and then pointing to right side 
      //inIdx-inStart = number of nodes left in the left side 
      // you can declare numsLeft=inIdx-inStart
        // this is because preorder => root, left, right so after left only will goahed with right so we are using a skipping of left nodes
        return root; 
    }
}
_________________________________________________________________________________________________________________________________________________
  class Solution {
    int prIdx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,inorder.length-1,preorder,inorder);
    }
    public TreeNode helper(int inStart, int inEnd,int[] preorder,int[] inorder){
        if(prIdx>preorder.length||inStart>inEnd){
            prIdx--;
            return null;
        }
        TreeNode root= new TreeNode(preorder[prIdx]);
        int inIdx=0;
        for(inIdx=inStart;inIdx<=inEnd;inIdx++){
            if(inorder[inIdx]==root.val)
                break;
        }
        prIdx++;
        root.left=helper(inStart,inIdx-1,preorder,inorder);// from inorder start point to the root index in inorder -1
        prIdx++;
        root.right= helper(inIdx+1,inEnd,preorder,inorder);//preStart+inIdx-inStart+1 => this is mainly due we are skipping what ever the left nodes(inIdx-inStart) from this will get the no.of of Left nodes from inorder and then pointing to right side 
        // this is because preorder => root, left, right so after left only will goahed with right so we are using a skipping of left nodes
        return root; 
    }
}
_____________________________________________________________________________________________________________________________________
  //This one uses hashmap and global varible to increment
class Solution {
    int pStart=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildBT(0,preorder.length-1,preorder,inorder,map);   
    }
    public TreeNode buildBT(int preStart,int preEnd,int[] preorder,int[]inorder,HashMap<Integer,Integer> map)  
    {
        if(preStart>preEnd||pStart>preorder.length){
            return null;
        }
        TreeNode root= new TreeNode(preorder[pStart]);
        int idx=map.get(preorder[pStart]);
        pStart++;
        root.left = buildBT(preStart,idx-1,preorder,inorder,map);
        root.right=buildBT(idx+1,preEnd,preorder,inorder,map);
        return root;
    }
}
