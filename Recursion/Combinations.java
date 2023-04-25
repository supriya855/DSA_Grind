// This is similar to the subsequences one with some modifications
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr= new int[n];
         for(int i=0;i<n;i++){
             arr[i]=i+1;
         }
         System.out.println(Arrays.toString(arr));
         List<Integer> list = new ArrayList<>();
         List<List<Integer>> res = new ArrayList<>();
         subSeq(0,arr,list,res,k);
         return res;
    }
    public void subSeq(int idx,int[] arr,List<Integer> list ,List<List<Integer>> res,int k){
        if(idx>=arr.length){
            if(list.size()==k)
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[idx]);
        subSeq(idx+1,arr,list,res,k);
        list.remove(list.size()-1);
        subSeq(idx+1,arr,list,res,k);
    }
}
