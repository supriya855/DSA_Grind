class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
    HashMap<Character,Integer> map = new HashMap<>();
    int max = 0,i=0,j=0;
    while(j<s.length()){
        map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
        if(map.size()==k) max = Math.max(max,j-i+1);
            if(map.size()>k){ // stucked directly removed from map withput reducing count 
              map.put(s.charAt(i),map.get(s.charAt(i))-1);
              if(map.get(s.charAt(i))==0){
                 map.remove(s.charAt(i));

              }
               i++;
            }

        j++;
    }
    if(map.size()<k) return -1;
    return max;
  }
}
