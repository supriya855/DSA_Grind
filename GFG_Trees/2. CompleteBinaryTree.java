class GfG
{
	boolean isCompleteBT(Node root)
    {
          //add code here.
          //Here the main intention is to Whenever we got null and its next should or next node should be null if so we directly return false
          //as that is not complete b.t
          Queue<Node> q = new LinkedList<>();
          q.add(root);
          boolean flag=false;
          while(!q.isEmpty()){
              int size=q.size();
              for(int i=0;i<size;i++){
                  Node latest = q.peek();
                  q.remove();
                  if(latest==null)
                  flag=true;
                  else{
                      if(flag){
                          return false;
                      }
                      q.add(latest.left);
                      q.add(latest.right);
                  }
              }
          }
          return true;
	} 
}
