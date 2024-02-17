//Got TLE for this but all test cases passed
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res = new ArrayList<>();
         boolean[] flag = new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(flag[i]==false){
             List<String> list = new ArrayList<>();
            for(int j=i+1;j<strs.length;j++){
                if(isAnagram(strs[i],strs[j])){
                    if(!list.contains(strs[i])){
                    list.add(strs[i]);
                    flag[i]=true;
                    }
                    list.add(strs[j]);
                    flag[j]=true;
                }
                
            } 
            if(flag[i]==false) list.add(strs[i]);           
            res.add(list);
            }
        }
          return res;
    }
    public boolean isAnagram(String s,String t){
        if(s.isEmpty()&&t.isEmpty()) return true;
        int[] alphabet = new int[26];
        if(s.equals(t)) return true;
        for(int i=0;i<s.length();i++) alphabet[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++) alphabet[t.charAt(i)-'a']--;
        for(int n: alphabet ){
            if(n!=0) return false;
        }
        return true;
   }
}
=======================================================================================
    class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] ch =s.toCharArray();
            Arrays.sort(ch);
            String keyStr= String.valueOf(ch);
            if(!map.containsKey(keyStr)) map.put(keyStr,new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
=======================================================================================
    class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] ch = new char[26];//instead of sort usig for less time complexity
            for(char c:s.toCharArray()) ch[c-'a']++;
            String keyStr= String.valueOf(ch);
            if(!map.containsKey(keyStr)) map.put(keyStr,new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
====================================================================================================
