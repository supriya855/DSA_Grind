class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        //bellman_ford algorithm helps to detect the negative cycles in directed graph
        // here this is applicable for directed graphs 
        // we convert undirected graphs into directed graph
        int[] dist = new int[V];
      
       for(int i=0;i<V;i++){
           dist[i] = (int)1e8;
       }
         dist[S] = 0;
        // realxing the edges V-1 times
        for(int i=0;i<V-1;i++){
            for(List<Integer>  list : edges){
                int u = list.get(0);
                int v = list.get(1);
                int wt = list.get(2);
                if(dist[u]!= 1e8 && dist[u]+wt < dist[v]){
                    dist[v] = dist[u]+wt;// this is the part of realaxation of edges
                }
            }
        }
        // Nth part of relaxing the nodes
        // so here if we find any relaxing one then we can say that its an 
        //negative cycle
        for(List<Integer> l : edges){
            int u = l.get(0);
                int v = l.get(1);
                int wt = l.get(2);
                if(dist[u]!= 1e8 && dist[u]+wt < dist[v]){
                    return new int[]{-1};
                }
        }
        return dist;
        
        
    }
}
