Max Sum Subarray of size K | Practice | GeeksforGeeks
Brute Force
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int sum=0,max=0;
        for(int i=0;i<=Arr.size()-K;i++){
            sum=0;
            for(int j=i;j<i+K;j++){
                sum+=Arr.get(j);
                max=Math.max(sum,max);
        }
        }
        return max;
    }
}
Here you can we doing a reptitve work that is we are taking prev values and again in second for loop to optimize it we are using a sliding window
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int i=0,j=0;
        long sum=0,max=0;
        while(j<Arr.size()){
           sum+=Arr.get(j);
           max=Math.max(sum,max);
           if(j-i+1<K) j++;
           else if(j-i+1==K){
               sum-=Arr.get(i);//here we are avoiding repetitve work
               i++;
               j++;
           }
        }
        return max;
    }
}
