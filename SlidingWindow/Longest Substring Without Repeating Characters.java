#Brute Force
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
       for(int i=0;i<s.length();i++){
           for(int j=i;j<s.length();j++){
                 HashSet<Character> set = new HashSet<>();
               List<Character> l = new ArrayList<>();
               for(int k=i;k<=j;k++){
                   l.add(s.charAt(k));
               }
               int count=0;
               for(int x=0;x<l.size();x++){
                   for(int y=x+1;y<l.size();y++){
                       if(l.get(x)==l.get(y)) count++;
                   }
               }
               if(count==0)
               max=Math.max(max,l.size());
               }
           }
       return max; 
    }
}
========================================================================================
  #Sliding Window + HashMap
  class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i=0,j=0,max=0;
        while(j<s.length())
        {
            mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j),0)+1);
            if(j-i+1<mp.size()){
                j++;
                // max=Math.max(mp.size(),max);
            }
            else if(j-i+1==mp.size()){
                max=Math.max(mp.size(),max);
                j++;
            }
            else if(j-i+1>mp.size()){
              while(j-i+1>mp.size()){
                     char leftChar = s.charAt(i);
                    mp.put(leftChar ,mp.get(leftChar)-1);
                    if(mp.get(leftChar)==0)
                    mp.remove(leftChar );
                    i++;
                }
                j++;
            }
        }
        return max;      
    }
}
// First Condition --> 
//"abcabcbb" --> abc -> 3
// "bbbbb" --> b ->1
//"pwwkew" --> pwke -> 4
========================================================================================
  # Sliding Window + HashSet
  class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen=0;
        int j=0;//using two pointers i,j for sliding window
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                maxLen = Math.max(maxLen,i-j+1);
            }
            else{
                while(s.charAt(j)!=s.charAt(i)){
                    set.remove(s.charAt(j));
                    j++;
                }
                set.remove(s.charAt(j));
                    j++;
                set.add(s.charAt(i));
            }

        }
        return maxLen;
    }
}


//This is all about sliding window + Hashset
// "abcabcbb"

// a-2
// b-4
// c-2
// "bbbbb"
// b-1
// "pwwkew"
// p=1
// w-2
// k-1
// e-1


// pw

// {wke}
