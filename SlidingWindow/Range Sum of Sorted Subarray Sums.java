class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] newArray = new int[n*(n+1)/2];//subarray count
        int idx =0;
        long res=0;
        for(int i=0;i<nums.length;i++){
            int sum =0;
            for(int j=i;j<nums.length;j++){
                if(i<=j){
                    sum+=nums[j];
                     newArray[idx++] = sum;
                }
            }
           
        }
        Arrays.sort(newArray);
        for(int i=left;i<=right;i++){
            res+=newArray[i-1];
        }
        return (int)(res%(int)(Math.pow(10,9)+7));
    }
}
