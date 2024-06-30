class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
       ArrayList<Integer> arr = new ArrayList<>();
       preorder(arr,root,0);
       return arr;
    }
    public void preorder(ArrayList<Integer> arr, Node root, int depth){
        if(root==null) return;
        if(arr.size()==depth) arr.add(root.data);
        preorder(arr,root.left, depth+1);
        preorder(arr,root.right,depth+1);
    }
}
