/*Q: Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]] 
_____________________________________________________________
Intution:
Step1: Take a boolean value or you can take count to check for each level take queue , list of list and sublist
step2: if root is not null add into queue 
step-3 if while q.is not null  
        - take size of q  and create sublist
        -traverse through the size 
              -pop the q value i.e (q.remove())
              - check if( level) add into a sublist at 0 position every time
              -else directly add into a sublist
              - with that value check if left and right exists if so add into a queue
        - after end of loop i.e each level is completed
           - changing level its oppposite value
           - adding into our final list
step-4 : return list
*/
//Approach -1
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean level = false;// for each level to check
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> res= new ArrayList<>();
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> sublist= new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.remove();// we are checking with respective remove value 
                if(level) sublist.add(0,node.val);
                else sublist.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                 }
            }
            level=!level;
            res.add(sublist);
        }
        return res;
    }
}
//Approach -2
class Solution{
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     int count=0;
     Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> res= new ArrayList<>();
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
          count++;
            int size=q.size();
            List<Integer> sublist= new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.remove();
              if(node.left!=null) q.add(node.left);
              if(node.right!=null) q.add(node.right);
              sublist.add(node.val);
            }
          if(count%2==0) Collections.reverse(sublist);
          res.add(sublist);
        }
     return res;
   }
}
     
  
