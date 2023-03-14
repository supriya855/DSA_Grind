/*Q: Sum Roo to leaf Number is you have to find the path from root to leaf and and add those numbers so do this for all the paths and sum all paths sum
example:   1
        /   \
       2     3
     output is : 25
     i.e root to leaf 1->2 i.e 12
     i.e root to leaft 1-> i.e 13
     total sum : 25
Approach :
-> Take two values as val and ans 
   -> val is used to upadate at every node for sum( i.e  val =0 then val=1 the val =12)
     -> ans is used when for a path ( ans =0 then ans=12 then ans=12+13=25)
-> To get that numbers we have to multiply val with 10 and add root val
-> check if it is leaf node update the root val
-> call the remaining function using recursion i.e left and right*/
Code :
class Solution {
    int ans=0;
    public int sumNumbers(TreeNode root) {
        int val=0;
        sumRootToLeaf(root,0);
        return ans;
    }
    public void sumRootToLeaf(TreeNode root,int val){
        if(root==null) return;
        val*=10;
        val+=root.val;
        if(root.left==null&&root.right==null){
            ans+=val;
            return;
        }
        sumRootToLeaf(root.left,val);
        sumRootToLeaf(root.right,val);
    }
}
