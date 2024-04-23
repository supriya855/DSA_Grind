class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res ="";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        int min = Math.min(first.length(),last.length());
        for(int i=0;i<min;i++){
            if(first.charAt(i)==last.charAt(i)){
                res+=first.charAt(i);
            }
            else 
             break;
        }
        return res;
    }
}
=====================================================
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
             while(strs[i].indexOf(prefix)!=0){ 
                // here we are checking first string with another one's in the string array '
                // if its equal it return 0 else it will retunr -1;
             prefix = prefix.substring(0, prefix.length()-1);

             }
        }
        return prefix;
    }
}
