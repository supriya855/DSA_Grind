class Solution {
    public void rotate(int[] nums, int k) {
    int[] temp= new int[nums.length];
    int idx=0;
     k=k%nums.length;
    for(int i=nums.length-k;i<nums.length;i++){
        temp[idx++]=nums[i];
    }
    for(int i=0;i<nums.length-k;i++){
        temp[idx++]=nums[i];
    }
   // System.out.println(Arrays.toString(temp));
    for(int i=0;i<nums.length;i++){
        nums[i]=temp[i];
    }
    }
}
=======================================================
class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
    }
    public void reverse(int[] nums,int s,int e){
        while(s<=e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
}
