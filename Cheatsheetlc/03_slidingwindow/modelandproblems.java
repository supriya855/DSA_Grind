//Sliding window
public int fn(int[] arr) {
    int left = 0, ans = 0, curr = 0;

    for (int right = 0; right < arr.length; right++) {
        // do logic here to add arr[right] to curr

        while (WINDOW_CONDITION_BROKEN) {
            // remove arr[left] from curr
            left++;
        }

        // update ans
    }

    return ans;
}
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
    long ans=0,curr=0;
    int left = 0;

    for (int right = 0; right < Arr.size(); right++) {
        // do logic here to add arr[right] to curr
        curr+=Arr.get(right);
        
        if (right-left+1==K) {//WINDOW_CONDITION_BROKEN
            // remove arr[left] from curr
            ans=Math.max(ans,curr);//
            curr=curr-Arr.get(left);
            left++;
        }
        
    }

    return ans;
}
}
