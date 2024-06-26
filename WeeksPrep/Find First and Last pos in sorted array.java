
O(LogN+LogN) = O(logN)
class Solution {
    public int[] searchRange(int[] arr, int target) {
        int firstIdx = binarySearchFirst(arr, target);
        int lastIdx = binarySearchLast(arr, target);
        return new int[] { firstIdx, lastIdx };
    }

    public int binarySearchFirst(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        int start = -1;
        while (s <= e) {
            int mid = (s + (e - s) / 2);
            if (arr[mid] == target) {
                start = mid;
                e = mid - 1;

            } else if (arr[mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return start;
    }

    public int binarySearchLast(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        int end = -1;
        while (s <= e) {
            int mid = (s + (e - s) / 2);
            if (arr[mid] == target) {
                end = mid;
                s = mid + 1;
            } else if (arr[mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return end;
    }
}
========================================================================
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length<1 || nums==null) return new int[]{-1,-1};
        int start = searchBinary(nums,target);
        if(start == nums.length || nums[start]!=target) return new int[]{-1,-1};
        int end = searchBinary(nums,target+1);// here we figure out the target +1 element idx and then we are returning end -1;
        return new int[]{start, end-1};
    }
    public int searchBinary(int[] nums,int target){
        int s= 0 , e= nums.length;
        while(s<e){
            int mid = s+(e-s)/2;
            if(nums[mid]<target)
            s = mid+1;
            else 
            e= mid;// why not mid-1 coz there mid itself a target
        }
        return s;
    }
}
