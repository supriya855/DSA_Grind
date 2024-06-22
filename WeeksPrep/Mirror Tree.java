
Whenever saw the question just imagine we have to swap just by loooking we can able get it 
think of level order and node swaps 

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        Queue<Node> q = new LinkedList();
        q.add(node);
        while(!q.isEmpty()){
            Node popNode  = q.poll();
                if(popNode.left!=null){
                q.add(popNode.left);
                }
                if(popNode.right!=null){
                q.add(popNode.right);
                }
                Node temp = popNode.left;
                    popNode.left = popNode.right;
                    popNode.right = temp;
          // this part of swap above also we can add before adding into queue
               // here it is same as level order but no for loop requore theere we need for every level to segregare
               // here we just need every individual node
        }
    }
}

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if(node == null) return;
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }
}


we can do with stack same level order
