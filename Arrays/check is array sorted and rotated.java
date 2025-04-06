// Question says that you have array which rotaed one 
// return true if its sorted and rotated version it contains


// My approach came was i stored num in new array i sorted
// on that i was performing possible rotations of len of arr type
// if that individula rotaion one equlas to original one return true
// cacthe in this solution was its O(n2)
class Solution {
    public boolean check(int[] nums) {
        int x = nums.length;
        int[] A = new int[x];
        for(int i=0;i<x;i++){
            A[i] = nums[i];
        }
        Arrays.sort(A);
       
            while(x!=0){
                int[] B = new int[nums.length];
                 for(int i=0;i<A.length;i++){
                    B[i] = A[(i+x)%A.length];
                 }
                 x--;                
                 int count = 0;
                   for(int k=0;k<nums.length;k++){
                        if(nums[k]==B[k]){
                            count++;
                        }
                   }
                   if(count==nums.length) return true;
            }
            return false;
        
    }
}
// my rotaions can be of arrlen or more than that % of my length does the same of whole length of an array only
// B[i] = A[(i+x)%A.length] for every valid index 



+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

  // here simple if we oberseve the multiple inputs

// in sorted version if prev elemne greater than next element more that twice then its not proper array return false

  
