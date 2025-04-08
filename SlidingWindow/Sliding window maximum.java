//TLE

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int count = 0,max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
           list.add(nums[i]);
            if(j<nums.length && list.size() == k){
             List<Integer> dummyList = new ArrayList<>(list);
               Collections.sort(dummyList);
              // System.out.println(list+" "+dummyList);
                resList.add(dummyList.get(dummyList.size()-1));
                list.remove(0);
                j++;
               
              
            }
        }
       int[] res = new int[resList.size()];
       for(int i=0;i<res.length;i++){
        res[i]= resList.get(i);
       }
       return res;
    }
}

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   // Amortized : O(N)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k <=0) return new int[0];
   Deque<Integer> dq = new ArrayDeque<>();
   int[] res = new int[nums.length-k+1];
   int idx = 0;
   for(int i=0;i<nums.length;i++){
   // exceeds window range means pop it

        while(!dq.isEmpty() && dq.peek()<i-k+1){
            dq.poll();
        }

          while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
            dq.pollLast();
        }

        dq.offer(i);
        if(i>=k-1){
            res[idx++]= nums[dq.peek()];
        }
   }
   return res;

    }
}
// TC : O(N) SC : O(N)
