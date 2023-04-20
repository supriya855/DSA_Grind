//[Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)

Using BFS

class Solution {
    // Using Level Order Traversal i.e BFS
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        if(root!=null)
        q.offer(root);
        int level=1;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(node.left==null&&node.right==null){
                    return level;
                }
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);
            }
            level++;// every level we are incrementing
        }
         return 0;
    }
}

******************************************************************
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left =minDepth(root.left);
        int right =minDepth(root.right);
       return left==0||right==0 ? 1+left+right:1+Math.min(left,right);
    }
}


The above one using DFS
