// it can done using brute force approach using two loops
// next is using two pointer by sorting an array and condiitons
// next below one using hashmap
class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(k-arr[i])){
                count+=map.get(k-arr[i]);
            }
           // map.putIfAbsent(arr[i],0); this works
           if(!map.containsKey(arr[i])){
               map.put(arr[i],0);
           }
            map.put(arr[i],map.get(arr[i])+1);
        }
        return count;
    }
}
