class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int prod=1;
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    prod*=nums[j];
                }
            }
            res[i]=prod;
        }
        return res;
    }
}
========================================================================
class Solution {
    public int[] productExceptSelf(int[] nums) {
    int[] leftProd = new int[nums.length];
    int[] rightProd = new int[nums.length];
    int[] ans = new int[nums.length];
    leftProd[0]=1;
    rightProd[nums.length-1]=1;
    for(int i=1;i<nums.length;i++){
        leftProd[i] = leftProd[i-1]*nums[i-1];
    }
    for(int i=nums.length-2;i>=0;i--){
        rightProd[i]=rightProd[i+1]*nums[i+1]; 
    }
    for(int i=0;i<ans.length;i++){
        ans[i]=leftProd[i]*rightProd[i];
    }
    return ans;
    }
}
===============================================================================
  class Solution {
    public int[] productExceptSelf(int[] nums) {
    int[] ans = new int[nums.length];
    Arrays.fill(ans,1);
     int curr=1;
    for(int i=0;i<nums.length;i++){
      ans[i]*=curr;
      curr*=nums[i];
    }
     curr=1;
    for(int i=nums.length-1;i>=0;i--){
       ans[i]*=curr;
       curr*=nums[i];
    }
    return ans;
    }
}
// [1,1,2,6]
// [6,8,12,24]
==============================================================================
  class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=right;
            right*=nums[i];
        }
        return res;
    }
}
