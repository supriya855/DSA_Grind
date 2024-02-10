//This one gives TLE Brute force approach only --O(n3)
class Solution {
    public int countSubstrings(String s) {
          int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String str ="";
                for(int k=i;k<=j;k++){
                    str+=s.charAt(k);
                }
               // System.out.println(str);
               if(isPalindrome(str)){
                   count++;
               }
            }
        }
        return count;
    }
    public boolean isPalindrome(String str){
        //if(str.length()==1) return true;
        int s=0,e=str.length()-1;
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)){
              return false;
            }
            s++;
            e--;
        }
        return true;
    }
}

*************************************************************************************************************

  // This also brute force -- O(n2)  reduced one from above one 
class Solution {
    public int countSubstrings(String s) {
          int count=0;
        for(int i=0;i<s.length();i++){
            String str ="";
            for(int j=i;j<s.length();j++){
                if(i<=j)
                str+=s.charAt(j);
               if(isPalindrome(str)){
                   count++;
               }
            }
        }
        return count;
    }
    public boolean isPalindrome(String str){
        //if(str.length()==1) return true;
        int s=0,e=str.length()-1;
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)){
              return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
