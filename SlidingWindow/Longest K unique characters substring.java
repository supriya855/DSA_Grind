

// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int max=-1;
        
        for(int i=0;i<s.length();i++){
            String res="";
            for(int j=i;j<s.length();j++){
                if(i<=j){
                   res+=s.charAt(j); 
                }
            }
           // System.out.println(res);
            
            String str="";
            HashSet<Character> set = new HashSet<>();
            for(int x=0;x<res.length();x++){
                if(!set.contains(res.charAt(x))){
                    str+=res.charAt(x);
                     set.add(res.charAt(x));
                }
                // else set.add(res.charAt(x));
            }
           // System.out.println("str : "+str);
            if(str.length()==k){
                max=Math.max(max,res.length());
            }
        }
        return max;
    }
}
TC: O(N2)
SC:O(N)
=======================================================================================



class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> map  = new HashMap<>();
        int i=0,j=0,max=-1;
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size()<k){
                j++;
            }
            else if(map.size()==k){
                  max=Math.max(max,j-i+1);
                 j++;
            }
            else if(map.size()>k){
                while(map.size()>k){
                     char leftChar = s.charAt(i);
                    map.put(leftChar ,map.get(leftChar)-1);
                    if(map.get(leftChar)==0)
                    map.remove(leftChar );
                    i++;
                }
               j++;
            }
          
        }
        return max;
    }
}
TC : O(N)
  SC: O(N)
