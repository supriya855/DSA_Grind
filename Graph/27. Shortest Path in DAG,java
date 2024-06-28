class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    // dfs of toposort
    public void dfs(int node, int[] visited, ArrayList<ArrayList<Pair>> adj,Stack<Integer> st)
    {
        visited[node] = 1;
        for(int itr =0;itr<adj.get(node).size();itr++){
            int v = adj.get(node).get(itr).first;
            if(visited[v]==0){
                dfs(v,visited, adj,st);
            }
        }
        st.push(node);// while back track pushing node to stack
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		// step.1 construct the graph with edges
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0;i<N;i++){
		    adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.length;i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(u).add(new Pair(v,wt));// graph is constrcuted with vertext and wt
		}
		// step - 2 do topo sort for linear ordering and to find all vertext dist from src
		Stack<Integer> st = new Stack<>();
		int[] visited = new int[N];
		for(int i=0;i<N;i++){
		    if(visited[i]==0){
		        dfs(i,visited,adj,st);
		    }
		}
		int[] dist = new int[N];
		for(int i=0;i<N;i++){
		    dist[i] = (int)(1e9);
		}
		dist[0] =0;// src node
		// step -3 storing all dist of indiviudal vertext by comparing smallest one
		while(!st.isEmpty()){
		    int node = st.peek();
		    st.pop();
		    for(int i=0;i<adj.get(node).size();i++){
		        int v = adj.get(node).get(i).first;
		        int wt = adj.get(node).get(i).second;
		        
		        if(dist[node]+wt < dist[v]){
		            dist[v] = wt+dist[node];
		        }
		    }
		    
		}
		  for (int i = 0; i < N; i++) {
            if (dist[i] == (int)(1e9)) {
                dist[i] = -1;
            }
        }
		return dist;
		
	}
}
