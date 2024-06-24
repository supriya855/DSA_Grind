1. BFS => Queue<Pair> in the pair it contains parent and child
2. so whenever there is a cycle parent != current adj node then we can there is a cycle
for(int itr : adj.get(node)){
  if(!vis){
    push to queue
  }
  else if 
check parent ! itr then return true => this means its alredy visited by someone
}




class Pair{
    int node;
    int parent;
    public Pair(int node,int parent){
         this.node = node;
         this.parent = parent;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        List<Integer> l = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false){
                if(bfs(i,visited,adj)) return true;
            }
        }
        return false;
        
        }
        public boolean bfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
            visited[start] = true;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(start,-1));
            while(!q.isEmpty()){
                int parent = q.peek().parent;
                int node = q.peek().node;
                q.remove();
              for(int itr : adj.get(node)){
                  if(!visited[itr]){
                      visited[itr] = true;
                      q.add(new Pair(itr,node));
                  }
                 else if(parent!=itr){
                      return true;
                  }
              }
            }
            return false;
        }
    }



2. DFS => We can do by keeping passing everytime the parent node as param if not !=current one we can return true



  

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
