class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[i]>nums2[st.peek()]){
                map.put(nums2[st.peek()],nums2[i]);
                st.pop();
            }
            st.push(i);
            map.put(nums2[i],-1);
        }
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                nums1[i] = map.get(nums1[i]);
            }
        }
        return nums1;
    }
}
