class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
       return helper(nums,nums.length-1, dp);
    }
    public int helper(int[] nums, int idx, int[] dp){
        if(idx < 0) return 0;
        if(idx==0) return nums[idx];
        if(dp[idx]!=-1) return dp[idx];
        //pick
        int pick = nums[idx]+helper(nums,idx-2,dp);// as idx-2 (from lasst we need skip adjacent ones)
        //not pick
        int notPick = helper(nums,idx-1,dp);

        return dp[idx] = Math.max(pick,notPick);
    }
}
