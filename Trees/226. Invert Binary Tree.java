class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left= invertTree(root.left);
        TreeNode right= invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}
// Recursion Flow
invertTree(4)
    invertTree(2)
        invertTree(1)
            invertTree(null) -> returns null
            invertTree(null) -> returns null
            // Swap left and right nodes of 1 (no-op since both are null)
            return 1
        invertTree(3)
            invertTree(null) -> returns null
            invertTree(null) -> returns null
            // Swap left and right nodes of 3 (no-op since both are null)
            return 3
        // Swap left and right nodes of 2
        // left=3, right=1
        root.left = 3
        root.right = 1
        return 2
    invertTree(7)
        invertTree(6)
            invertTree(null) -> returns null
            invertTree(null) -> returns null
            // Swap left and right nodes of 6 (no-op since both are null)
            return 6
        invertTree(9)
            invertTree(null) -> returns null
            invertTree(null) -> returns null
            // Swap left and right nodes of 9 (no-op since both are null)
            return 9
        // Swap left and right nodes of 7
        // left=9, right=6
        root.left = 9
        root.right = 6
        return 7
    // Swap left and right nodes of 4
    // left=7, right=2
    root.left = 7
    root.right = 2
    return 4
 *******************************************************************************
 // BFS or Level Order Traversal
 // you can do the same using stack data structure as linkedlist 
 class Solution {
    public TreeNode invertTree(TreeNode root) {
       if(root==null) return root;
        Queue<TreeNode> q= new LinkedList<>();
        if(root!=null){
            q.add(root);
        }
        while(!q.isEmpty()){
           TreeNode node = q.remove();
           TreeNode left = node.left;
           node.left=node.right;
           node.right=left;// swapped
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            return root;
    }
}
***********************************
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left =root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(left);
        return root;
    }
}
