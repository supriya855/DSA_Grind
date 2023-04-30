class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int row=0;row<mat.length;row++){
            for(int col=0;col<mat[0].length;col++){
                map.put(mat[row][col],new int[]{row,col});
            }
        }
        int[] r = new int[mat.length];
        int[] c= new int[mat[0].length];
        for(int i=0;i<arr.length;i++){
            int[] res = map.get(arr[i]);// we get matrix values so res[] ={0,0};
            r[res[0]]++;
            c[res[1]]++;
            if(r[res[0]]==mat[0].length|| c[res[1]]==mat.length)
                return i;
        }
        return -1;
    }
}
**********************************************************************
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
       Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<mat.length;i++){
            int currMin=0;
            for(int j=0;j<mat[0].length;j++){
                currMin=Math.max(currMin,map.get(mat[i][j]));
            }
            ans=Math.min(ans,currMin);
        }
        for(int j=0;j<mat[0].length;j++){
            int currMin=0;
            for(int i=0;i<mat.length;i++){
                currMin=Math.max(currMin,map.get(mat[i][j]));
            }
            ans=Math.min(ans,currMin);
        }
        return ans;
    }
}
