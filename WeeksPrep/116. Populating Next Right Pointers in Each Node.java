You just need to analyze the question well you can soln easily

  class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node temp = root;
        Node prev = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                    q.peek().left.next = q.peek().right;
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                    if (size >= 2){
                    if(q.peek().next!=null)
                        q.peek().right.next = q.peek().next.left;
                    }
                }
                q.remove();
            }
        }
        return temp;
    }
}
