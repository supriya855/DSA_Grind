class Solution {
    public void bfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, int[] dist){
        Queue<Integer> q = new LinkedList<>();
        visited[node] =1;
        q.add(node);
        while(!q.isEmpty()){
            int popNode = q.poll();
            for(int itr : adj.get(popNode)){
                if(visited[itr]==0){
                if(dist[popNode]+1 < dist[itr]){
                    dist[itr] =1+dist[popNode];
                }
                visited[itr] = 1;
                q.add(itr);
                }
            }
            
        }
        
    }
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        // Constrcut the graph 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited = new int[n];
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = (int)(1e9);
        }
        dist[src] =0;
        for(int i=0;i<n;i++){
            if(visited[i] ==0){
                bfs(i,visited,adj,dist);
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==1e9){
                dist[i]= -1;
            }
        }
        return dist;
        
    }
}
