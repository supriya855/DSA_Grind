Here this is also same as number of islands
one tric part as they said it should be rotated or image one of previous for that purpose we are subtrating each list of node i.e row and col
to a base row col
so that it results same then we can add into set and it will unqiue one's this was the difference from islands
TC : O(MXN)
SC: O(MXN)

BFS
====
  

// User function Template for Java

class Solution {
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1){
                 ArrayList<String> list = new ArrayList<>();
                    bfs(i,j,grid,visited,list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    public void bfs(int i, int j, int[][] grid, boolean[][] visited, ArrayList<String> list){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        list.add(toString(i-i,j-j));
        visited[i][j] = true;
        while(!q.isEmpty()){
            int f = q.peek().first;
            int s = q.peek().second;
            q.remove();
            int[] row = {-1,0,1,0};
            int[] col = {0,1,0,-1};
            for(int k=0;k<4;k++){
                int rowIdx = f+row[k];
                int colIdx = s+col[k];
            if(rowIdx>=0 && rowIdx<grid.length &&colIdx>=0 && colIdx < grid[0].length && grid[rowIdx][colIdx]==1 &&
            !visited[rowIdx][colIdx]){
                visited[rowIdx][colIdx] = true;
                q.add(new Pair(rowIdx, colIdx));
                list.add(toString(rowIdx-i, colIdx-j));
            }
        }
    }
}
    public String toString(int r, int c){
        return Integer.toString(r)+ " " +Integer.toString(c);
    }
}

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

DFS
===


// User function Template for Java

class Solution {
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1){
                 ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,grid,visited,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    // TC : O(nXmX log(nxm))+O(nxm) for bfs log for add data into set
    public void dfs(int i, int j, int[][] grid, boolean[][] visited, ArrayList<String> list,
    int baseI, int baseJ){
        
        list.add((i-baseI)+" "+(j-baseJ));
        visited[i][j] = true;
            int[] row = {-1,0,1,0};
            int[] col = {0,1,0,-1};
            for(int k=0;k<4;k++){
                int rowIdx = i+row[k];
                int colIdx = j+col[k];
            if(rowIdx>=0 && rowIdx<grid.length &&colIdx>=0 && colIdx < grid[0].length &&
            grid[rowIdx][colIdx]==1 &&
            !visited[rowIdx][colIdx]){
               dfs(rowIdx,colIdx,grid,visited,list,baseI,baseJ);
            }
        }
}
    // public String toString(int r, int c){
    //     return Integer.toString(r)+ " " +Integer.toString(c);
    // }
}

// class Pair{
//     int first;
//     int second;
//     public Pair(int first, int second){
//         this.first = first;
//         this.second = second;
//     }
// }
