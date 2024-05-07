//Count Nice subarrays
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res =0,curr=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            curr+= nums[i]%2;//here we are keeping 0 or 1 based on odd or even 
            //odd =1 even =0;
            //curr count increase until another odd number visible
            map.put(curr,map.getOrDefault(curr,0)+1);
            res+=map.getOrDefault(curr-k,0);
           // System.out.println(curr+" "+map+ " "+res);
        }
        return res;
    }
}

// [1,1,2,1,1] --> 
// curr = 0 -> 1-> 2 -> 2-> 3-> 4
// ans = 0->1 ->
// {0,1} --> {1,1} -> {2,2} -> {3,1}
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subArray(nums, goal) - subArray(nums, goal - 1);
    }
//Binary subarray with sum 
    public int subArray(int[] nums,int goal){
        int j=0,i=0;
        int currSum=0,total=0;
        while(j<nums.length){
                currSum+=nums[j];
                 while(i<=j && currSum>goal){
                currSum-=nums[i];
                i++;
            }
                total+=j-i+1; 
                j++;
            
            
            }
return total;
}

}

//Subarray Sum Equals K
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum =0,res=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.get(sum-k)!=null){
                res+=map.get(sum-k);
            }
            if(sum==k) res++;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
