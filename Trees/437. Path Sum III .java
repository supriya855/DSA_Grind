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
   public int pathSum(TreeNode root, int sum) {
    if (root == null)
      return 0;
    return dfs(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int dfs(TreeNode root, int sum, long cur) {
    if (root == null)
      return 0;
    cur += (long)root.val;
    return (cur == (long)sum ? 1 : 0) + dfs(root.left, sum, cur) + dfs(root.right, sum, cur);
  }
}
=================================================================================================
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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Long> map = new HashMap<>();
        map.put((long)0,(long)1);
        helper(root,0,targetSum,map);
        return count;
    }
    int count=0;
    public void helper(TreeNode root,long currSum,int targetSum,HashMap<Long,Long> map){
        if(root==null) return;
        currSum+=(long)root.val;
        if(map.containsKey(currSum-targetSum)){
            count+=map.get(currSum-targetSum);
        }
        if(!map.containsKey(currSum)){
            map.put(currSum,(long)1);
        }
        else{
            map.put(currSum,map.get(currSum)+1);
        }
        helper(root.left,currSum,targetSum,map);
        helper(root.right,currSum,targetSum,map);
        map.put(currSum,map.get(currSum)-1);


    }
}
//Dooo DRYYYY lottt
