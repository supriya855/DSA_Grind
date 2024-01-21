class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0,result=0;
        Map<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);// this is needed when subtract the the value is same as k that it also one subarray to get that value as 1 and it is valid subarray sum==k
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(prefixSum.containsKey(sum-k)){ //if (sum[0, end] - k == sum[start, end]) 
                result+=prefixSum.get(sum-k);
            }
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        }
        return result;
    }
}
/* [1,2,3] k=3
 [1]
 {0,1} {1,1} {3,1} 
 is(1-3)=is(-2)
 is(3-2) is(0) then yes 
 result=2

 */
