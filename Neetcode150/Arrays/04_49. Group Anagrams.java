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
