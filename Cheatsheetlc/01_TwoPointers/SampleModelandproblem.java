//Two pointers: one input, opposite ends
public int fn(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    int ans = 0;

    while (left < right) {
        // do some logic here with left and right
        if (CONDITION) {
            left++;
        } else {
            right--;
        }
    }

    return ans;
}

//167. Two Sum II - Input Array Is Sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int left =0,right =numbers.length-1;
       while(left<=right){
           if(numbers[left]+numbers[right]==target) 
           return new int[]{left+1,right+1};
           else if(numbers[left]+numbers[right]>target)
           right--;
           else
           left++;
       }
       return new int[]{-1,-1};
    }
}
