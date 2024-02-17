// Question : Given an unsorted we need find the longest consecutive sequene
// Approach : consecutive sequence means 1,2,3,4,5.......so on
// Sorted the array checked both are consecutive or not
//   if both are same skipping that increasig the count
//   if both two numbers mismatched count is again starting(becuase we missed consecutive) used max variable
  
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        int count=1,max=1,i=0;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1]) count++;
            else if(nums[i]==nums[i+1]) continue;
            else count=1;
            max=Math.max(count,max);
        }
        return max;
    }
}
// [1,2,0,1]
// [0,1,1,2]
// [9,1,4,7,3,-1,0,5,8,-1,6]
===========================================================================================================
//Brute Force -2
  class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        if(nums.length==0) return 0;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // System.out.println(map);
        List<Integer> l = new ArrayList<>(map.keySet());
        int count=1,max=1;
        for(int i=0;i<l.size()-1;i++){
            if(l.get(i)+1==l.get(i+1)){
                count++;
            }
            else{
                count=1;
            }
            max=Math.max(count,max);
        }
        return max;
    }
}
============================================================================================================
  //Boundary 
  //MAP only checking the boundaries of each number is that present if so boundaries we are storing in a left and right
  class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        int max=0;
        for(int n:nums){
            if(!map.containsKey(n)){
                int left = map.containsKey(n-1)?map.get(n-1):0;
                int right = map.containsKey(n+1)?map.get(n+1):0;
                int sum=left+right+1;
                map.put(n,sum);
                max=Math.max(max,sum);
// nothing will do if n has no neighbours
                if(left>0||right>0){
                    map.put(n-left,sum);
                    map.put(n+right,sum);
                }
            }
            
        }
        return max;
    }
}
