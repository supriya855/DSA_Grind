Question :
===========
Given a grid where 1 represents land and 0 represent water where you need find out the number of islands
where one island you can traverse 8 directional

Theory
=========
So when you see this question you can't directly in your mind it triggers as graph
but its a graph problem 
  analyze with sample examples
where if you find island you need to traverse 8 direction make count as 1 
so these traverse one can be done using BFS 

  Lets get into theory intution part how we can solve

  1. We need a visted array of grid whereever we found land i.e 1 and that to non visited one
2. we we call bfs and here whenever if we call we increment the count
3. will store the respective row col pair in queue
traverse through the queu pop the stored row,cols and that respective one's will go for 8 directions
4. for that pair will traverse 8 directions will check here for every one is this non visited and grid of i,j is 1 
if so will check condition what ever the 8 direction on with grid length
after condition satisfies wil mark respective one true; and add into to the   queue
5. will repeat this process until q.isempty
=======================================================
CODE
=====
  

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // Code here
        int resCount = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]== '1'){
                    bfs(i,j,visited,grid);
                    resCount++;
                }
            }
        }
        return resCount;
    }
    public void bfs(int i, int j, boolean[][] visited, char[][] grid){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        visited[i][j] = true;
        int[]  row = {-1,-1,0,1,1,1,0, -1};
        int[] col = {0,1,1,1,0,-1,-1,-1};
        while(!q.isEmpty()){
            int rIdx = q.peek().f;
            int cIdx = q.peek().s;
            q.remove();
        for(int itr = 0; itr< 8;itr++){
            int rowIdx = rIdx+row[itr];
            int colIdx = cIdx+col[itr];
             //if(grid[rowIdx][colIdx]=='1'){
             if(rowIdx>=0 && rowIdx<grid.length && colIdx>=0 && colIdx<grid[0].length && grid[rowIdx][colIdx]=='1' && 
             !visited[rowIdx][colIdx]){
                 
              visited[rowIdx][colIdx] = true;
              q.add(new Pair(rowIdx,colIdx));
             }
            //}
          }
        }
        
    }
    
}
class Pair{
    int f;
    int s;
    public Pair(int f, int s){
        this.f = f;
        this.s = s;
    }
}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // Code here
        int resCount = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]== '1'){
                    bfs(i,j,visited,grid);
                    resCount++;
                }
            }
        }
        return resCount;
    }
    public void bfs(int i, int j, boolean[][] visited, char[][] grid){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        visited[i][j] = true;
        // int[]  row = {-1,-1,0,1,1,1,0, -1};
        // int[] col = {0,1,1,1,0,-1,-1,-1};
        while(!q.isEmpty()){
            int rIdx = q.peek().f;
            int cIdx = q.peek().s;
            q.remove();
            // shorcut for the 8 directional one both will work
        for(int itrR = -1;itrR<=1;itrR++){
            for(int itrC = -1;itrC<=1;itrC++){
            int rowIdx = rIdx+itrR;
            int colIdx = cIdx+itrC;
             if(rowIdx>=0 && rowIdx<grid.length && colIdx>=0 && colIdx<grid[0].length && grid[rowIdx][colIdx]=='1' && 
             !visited[rowIdx][colIdx]){
                 
              visited[rowIdx][colIdx] = true;
              q.add(new Pair(rowIdx,colIdx));
             }
            }
          }
        }
        
    }
    
}
class Pair{
    int f;
    int s;
    public Pair(int f, int s){
        this.f = f;
        this.s = s;
    }
}




