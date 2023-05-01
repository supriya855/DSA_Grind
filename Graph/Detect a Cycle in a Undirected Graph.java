class Solution {
    // Function to detect cycle in an undirected graph.
    private boolean is_cycle(int i,boolean[] vis,int V,ArrayList<ArrayList<Integer>> adj){
        vis[i]=true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,-1));
       while(!q.isEmpty()){
           int node =q.peek().first;
           int parent=q.peek().second;
           q.remove();
           for(int k: adj.get(node)){
               if(vis[k]==false){
                   q.add(new Pair(k,node));
                   vis[k]=true;
               }
               else if(parent!=k){
                   return true;
               }
           }
       }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V+1];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
            if(is_cycle(i,vis,V,adj)==true){
                return true;
            }
            }
        }
        return false;
    }
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
}


