https://leetcode.com/problems/longest-consecutive-sequence/description/
1. naive approach sort array check nums[i]-1 == nums[i] take max count
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count=1,max=0;
        if(nums.length==0) return 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
               continue;
            }
            else if(nums[i-1]+1 == nums[i]){
                count++;
                max=Math.max(max,count);
            }
            else{
                count=1;
            }

        }
        return max<=1? 1 : max;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        if( nums.length==0) return 0;
        if(nums.length==1) return 1;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count = 1,prev =0, curr = -1,max =0;
        boolean flag = false;
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            if(flag==false){
                 prev = mp.getKey();
                 flag = true;
            }
            else{
                 curr = mp.getKey();
                if( curr - prev == 1){
                    // System.out.println(mp.getKey()+" "+prev+" "+count);
                    count++;
                    prev = curr; 
                }
             else {
                prev = curr;
                count =1;
             }

            }
            max = Math.max(max,count);
        }
        return max;
    }
}
// TC : O(N) Sc : O(N)

3. With haset also we can do it
public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int ans = 0;
        for(int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            ans = Math.max(ans,right - left - 1);
            if(set.isEmpty()) return ans;//save time if there are items in nums, but no item in hashset.
        }
        return ans;
    }
4. with HAshMap inserting while it has neigbour nodes present like num+1 and num-1 while insering we are caluvulationh
public int longestConsecutive(int[] num) {
    int res = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int n : num) {
        if (!map.containsKey(n)) {
            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
            // sum: length of the sequence n is in
            int sum = left + right + 1;
            map.put(n, sum);
            
            // keep track of the max length 
            res = Math.max(res, sum);
            
            // extend the length to the boundary(s)
            // of the sequence
            // will do nothing if n has no neighbors
            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        else {
            // duplicates
            continue;
        }
    }
    return res;
}
