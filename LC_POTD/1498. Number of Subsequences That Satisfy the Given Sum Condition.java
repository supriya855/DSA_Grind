class Solution {
    public int numSubseq(int[] nums, int target) {
        int modulo=(int)1e9+7;
        Arrays.sort(nums);
        int start=0,count=0;
        int end=nums.length-1;
        int[] power= new int[nums.length];
        power[0]=1;
        for(int i=1;i<power.length;i++){
            power[i]=2*power[i-1]%modulo;
        }
        while(start<=end){
            if(nums[start]+nums[end]>target)
            end--;
            else{
                count+=power[end-start];
                count%=modulo;
                start++;
            }
        }
        return count;
    }
}
// A trick here is sort the array
// one more with help of two pointer you can able to find valid susequences
// when the condition satisfies then only we are finding valid subseq with that range all the seq are valid (instead of finding we are using 2^(end -start)) it will give us valid subseq in the range
