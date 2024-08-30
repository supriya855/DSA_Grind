Question : You need find ceil of Binary Search Tree
you are given key for that key you need any node BST which immedidate grater or equal to that node
    for ex-1:
      5
    1    6
     2
      3
key =3
output : 3 
EX -2:
   6
1    7
 3     8
         9
key is 7
output is 8 as there node in the above tree which equals to the 7 so the immediate grater is 8 output is 8

INTUTION :
1.
My first intution traverse it using inorder
then store it in list traverse through list list of value > = key means return it

2. 
Use varible like ceil 
if root.val>key store in ceil value traverse through the tree using recursion (or using while with if and else conditions)

O(height of a tree ) 


// User function Template for Java

class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        List<Integer> l = new ArrayList<>();
        inorder(root,l);
        for(int i=0;i<l.size();i++){
      
            if(l.get(i)>=key) {
                // System.out.println(l.get(i)+" "+key);
                return l.get(i);
                
            }
        }
        return -1;
    }
    public void inorder(Node root,List<Integer> l){
        if(root==null) return;
        inorder(root.left,l);
        l.add(root.data);
        inorder(root.right,l);
    }
}


===========================================================================


// User function Template for Java

class Tree {
    int ceil = -1;
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return ceil;
        // Code here
        if(root.data==key) return root.data;
        else if(root.data>key){
            ceil = root.data;
           return findCeil(root.left,key);
        }
        else{
            
          return  findCeil(root.right,key);
        }
    }
}

