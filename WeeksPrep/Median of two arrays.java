class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        // taking smaller one length at first so checking if not switiching
        if(x>y){
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = x;
        while(low <= high){
            int partitionX = (low+high)/2;
            int partitionY = (x+y+1)/2 - partitionX;
// if theere is no elemnts we are smallest values
            int maxLeftX = (partitionX==0)?Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = (partitionX==x)? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = (partitionY==0)? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = (partitionY==y) ? Integer.MAX_VALUE : nums2[partitionY];
            // found parition check its odd or even
            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                // we founf the correct match partition
                if((x+y)% 2 ==0){
                    // its even length then take avg of max of lefts side and min right sides
                    return 
                   ((double)Math.max(maxLeftX,maxLeftY)+Math.min(minRightX, minRightY))/2;

                }
                // odd len max of left sides
                else return (double)(Math.max(maxLeftX,maxLeftY));
            }
            // move towards left in X
            else if(maxLeftX>minRightY)// we are too far to the right side got to left part
            high = partitionX-1;
            else
            low = partitionX+1;// move towards right x

        }
        return -1;
    }
}

// Main intution here we have alreday sorted array we have to merge so to merge 
// we are using binary search to figure the median directly without manually mergeing
// here we are using partioning this partition based on binary search
// if high or low partionX and paritionY we are moving 
// and figuring the median based on the length
