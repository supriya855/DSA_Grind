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
