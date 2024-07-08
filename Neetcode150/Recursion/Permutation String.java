class Solution {
    public boolean checkInclusion(String s1, String s2) {
     List<String> list = new ArrayList<>();
       permutation(s1,s2,"",list);
       System.out.println(list);
       for(int i=0;i<list.size();i++){
        if(s2.contains(list.get(i))){
            return true;
        }
       }
       return false;
    }
    public void permutation(String s1,String s2,String s, List<String> list){
        if(s1.length()==s.length()) {
            list.add(s);
            return;
        }
        for(int i=0;i<s1.length();i++){
            String curr = "";
            curr+=s1.charAt(i);
            if(s.contains(curr)) continue;
            s+=s1.charAt(i);
            permutation(s1,s2,s,list);
            s = s.substring(0,s.length()-1); 
        }
    }
}
// abc 
// 3!= 3*2*1 = 6 ways i can arrange it
// abc
// acb
// bca
// bac
// cab
// cba
// 6 ways I formed so these are the permutations of a string
// so now check is there any of the permutation of s1 is contained by the s2
// yes or no
// ["abc","acb","bca","bac","cab","cba"]
// //traverse and check
// s2.contains(any one from above list)
