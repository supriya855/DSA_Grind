

/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        //here our directed graph will not work because of directed path 
        // the one which not cycle in directed graph can be cycle undirected graph
        // refer striver vid for exmple or
//         6 5
// 5 3
// 3 1
// 1 2
// 2 4
// 4 0
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
            if(dfs(i,vis,pathVis,adj) == true) 
                  return true;
            }
        }
        return false;
    }
    public boolean dfs(int i,int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[i]=1;
        pathVis[i]=1;
        for(int itr : adj.get(i)){
            if(vis[itr]==0){
                if(dfs(itr,vis,pathVis,adj)==true) 
                  return true;
            }
            else if(pathVis[itr]==1) return true;
        }
        pathVis[i]=0;// while backtrack make pathVis unmarked for new path cycle
        return false;
        
    }
}

We can also use topo sort as we topo sort is applicable for DIrected ascyclic graph 
if topo sort is failing means there is a cycle


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        // add your code here
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
     int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return count!=V;// this how we are verifyinh
    }
}
