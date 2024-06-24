class Solution{
public ArrayList<Integer> dfs(int V, List<List<Integer>> adj){
boolean[] visited = new boolean[V];
          ArrayList<Integer> res = new ArrayList<>();

   for(int i=0;i<V;i++){
    if(!visited[i]){
       dfs(i,visited,adj, res);
     }
    }
return res;
}
public void dfs(int node, boolean[] visited,  ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res){
visited[node] = true;
res.add(node);
for(int itr : adj.get(node)){
  if(!visited[itr]){
  dfs(itr,visited, adj, res);
  }
}
