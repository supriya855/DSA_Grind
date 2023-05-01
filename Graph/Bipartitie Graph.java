// A graph is said to be Bipartite graph when 2 color will be taken and its adjnode color should be differnet
// Linear graph with no cycles is always a Bipartite graph
// A graph cycle has even length the it Bipartite graph else not a bipartite
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color=new int[V];
        for(int i=0;i<color.length;i++){
            color[i]=-1;
        }
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(bfs(i,V,color,adj)==false) return false;
            }
        }
        return true;
    }
    public boolean bfs(int i,int V,int[] color,ArrayList<ArrayList<Integer>>adj){
        color[i]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int val=q.remove();
            for(int adjNode:adj.get(val)){
                if(color[adjNode]==-1){
                     q.add(adjNode);
                    color[adjNode]=1-color[val];// 1-0=1 and 1-1=0
                }
                else if(color[adjNode]==color[val]) return false; // if adjnode and curr node has same values
                
            }
            
        }
        return true;
    }
}
