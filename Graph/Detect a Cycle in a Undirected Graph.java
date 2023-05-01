//Question Link : https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph
// Using BFS
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
**********************************************************************
//Using DFS
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
            if(dfs(i,-1,adj,vis)==true)
            return true;
            }
        }
            return false;
        }
        public boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
            vis[node]=true;
            for(int i:adj.get(node)){
                if(vis[i]==false){
                   if(dfs(i,node,adj,vis)==true) {
                          return true;
                   }
                }
                    else if(i!=parent) return true;
                
            }
            return false;
        }
    }


