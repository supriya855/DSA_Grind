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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        q.add(root);
        int max=Integer.MIN_VALUE,count=1;
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                sum+=q.remove().val;
            }
            max=Math.max(sum,max);
            if(!map.containsKey(sum))
            map.put(sum,count++);
            else{
                map.put(sum,count-1);
            }
        }
        System.out.println(map);
            if(map.containsKey(max)){
                return map.get(max);
            }
  return -1;
    }
}
//here my approach is level order traversal
// while traversing each sum and find the max sum along with count the level


class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max=Integer.MIN_VALUE,count=0,minL=0;
        while(!q.isEmpty()){
            int size=q.size();
            count++;
            int sum=0;
            for(int i=0;i<size;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                sum+=q.remove().val;
            }
        if(sum>max){
            max=sum;
            minL=count;
        }
        }
         return minL;   
    }
}
