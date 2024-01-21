class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                pos.add(nums[i]);
            }
            else
                neg.add(nums[i]);
        }
        int idx=0;
        for(int i=0;i<nums.length;i+=2){
            if(idx<pos.size())
            nums[i]=pos.get(idx++);
        }
        int idxN=0;
        for(int i=1;i<nums.length;i+=2){
            if(idxN<neg.size())
            nums[i]=neg.get(idxN++);
        }
        return nums;
    }
}
========================================================================
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] num = new int[nums.length];
        int k=0,j=1;
        for(int i=0;i<nums.length;i++){
          if(nums[i]>=0){
              num[k]=nums[i];
              k=k+2;
          }
          else{
              num[j]=nums[i];
              j+=2;
          }
        }
        return num;
    }
}
