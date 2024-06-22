TOPSORT USING DFS => JUST DAG TRAVERSAL
we are storing all element in stack while backtrack we can psuh to stack at the end we can pop get all elements

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,adj, st);
            }
        }
        int[] res = new int[V];
        int idx=0;
        while(!st.isEmpty()){
            res[idx++] = st.pop();
        }
        return res;
    }
    public static void dfs(int i, int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[i]=1;
        for(int itr : adj.get(i)){
            if(vis[itr]==0){
                vis[itr]=1;
                dfs(itr,vis,adj,st);
                
            }
        }
        st.push(i);
    }
}


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
