//For this question Done lot of different using level order 
//using a stack and without using stack
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
         ArrayList<Integer> res = new ArrayList<>();
        int count=0;
        if(node==null) return res;
        Queue<Node> q =new LinkedList<>();
         //ArrayList<ArrayList<Integer>> re = new ArrayList<>();
         Stack<Integer> st = new Stack<>();
          q.add(node);
        while(!q.isEmpty()){
                Node tmp=q.poll();
                st.push(tmp.data);
                 if(tmp.right!=null){
                    q.add(tmp.right);
                }
                 if(tmp.left!=null){
                    q.add(tmp.left);
                }
            }
            while(!st.isEmpty()){
                res.add(st.pop());
            }
        
        return res;
        
    }
}    
============================================================================
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
         ArrayList<Integer> res = new ArrayList<>();
        int count=0;
        if(node==null) return res;
        Queue<Node> q =new LinkedList<>();
         //ArrayList<ArrayList<Integer>> re = new ArrayList<>();
         //Stack<Integer> st = new Stack<>();
          q.add(node);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node tmp=q.poll();
                if(res.isEmpty()){
                    res.add(tmp.data);
                }
                else{
                    res.add(i,tmp.data);
                }
                 if(tmp.left!=null){
                    q.add(tmp.left);
                }
                  if(tmp.right!=null){
                    q.add(tmp.right);
                }
            }
        }
        
        return res;
        
    }
}        
