

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        q.add(0);
        visited[0] = true;
       while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int itr : adj.get(node)){
                if(!visited[itr]){
                    visited[itr] = true;
                    q.add(itr);
                }
            }
            
        }
        return res;
    }
}
