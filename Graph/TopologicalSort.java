class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] indegree= new int[V];
        for(int i=0;i<V;i++){
            for(int node:adj.get(i)){
                indegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
       int[] topo= new int[V];
       int idx=0;
        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int val = q.poll();
            topo[idx++]=val;
            for(int adjNode: adj.get(val)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0) q.add(adjNode);
            }
        }
        return topo;
    }
}
