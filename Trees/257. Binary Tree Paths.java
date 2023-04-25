//Brute Force
class Solution {
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String str="";
        paths(root,str);
        return list;
    }
    public void paths(TreeNode root,String str){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            str=str+root.val;
            list.add(str);
            return;
        }
     paths(root.left,str+root.val+"->");
     paths(root.right,str+root.val+"->");

    }
}
// Optimized one
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
         List<String> list = new ArrayList<>();
         StringBuilder s= new StringBuilder();
            paths(root,list,s);
            return list;
    }
    public void paths(TreeNode root,List<String> list,StringBuilder s){
        if(root==null) return;
        int len =s.length();
        s.append(root.val);
        if(root.left==null&&root.right==null){
            list.add(s.toString());
        }
        s.append("->");
     paths(root.left,list,s);
     paths(root.right,list,s);
    s.setLength(len);// this is to set length of s to 0 so that 
    // we can add individual character 
    }
}
