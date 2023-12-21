class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        System.out.println(map);
        int idx=0;
        for(Map.Entry<Integer,Integer> mp:map.entrySet()){
            if(mp.getValue()>2){
                int num=2;
                while(num!=0){
                    nums[idx++]=mp.getKey();
                num--;
                }
            }
                else{
                    int num=mp.getValue();
                   while(num!=0){
                    nums[idx++]=mp.getKey();
                num--;
                }
            }
        }
    return idx;
}
}
