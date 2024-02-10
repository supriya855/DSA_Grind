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
*********************************************************************************

    class Solution {
    int count =0;
    public int countSubstrings(String s) {
        if(s==null||s.length()==0) return 0;
        for(int i=0;i<s.length();i++){
            extendPalindrome(s,i,i);//odd length
            extendPalindrome(s,i,i+1);//even length
        }
        return count;
    }
    public void  extendPalindrome(String s,int left,int right){
        while(left>=0 &&right<s.length() &&s.charAt(left)==s.charAt(right)){//main logic lies here , we are checking substring here also madam ada (when i is at d postition i.e (2,2) (ada , madam for this two conditions count increases here))
                count++;
                left--;
                right++;
            }
        }
}
// "abc" ---> a, b, c, ab, bc, abc
// extendPalindrome("abc",0,0); yes--> a
// extendPalindrome("abc",0,1):no ab

// extendPalindrome("abc",1,1);yes --> b
// extendPalindrome("abc",1,2);no --> bc 


// extendPalindrome("abc",2,2); yes ---> c
// extendPalindrome("abc",0,2); no abc

// This extendPalindrome as a substring at a time we are forming substing and increasing the count values

// "aabca"--> a,aa,aab,aabc,aabca
//            a,ab,abc,abca
//            b,bc,bca
//            c,a
//  length : 5    
//  -----------------------      
// extendPalindrome("aabca",0,0); yes--> a
// extendPalindrome("aabca",0,1):yes--> aa

// extendPalindrome("aabca",1,1);yes --> a
// extendPalindrome("aabca",1,2);no --> ab 


// extendPalindrome("aabca",2,2); yes ---> b
// extendPalindrome("abaabcac",2,3); no --->bc

// extendPalindrome("aabca",3,3); yes ---> c
// extendPalindrome("abaabcac",3,4); no --->ca

// extendPalindrome("aabca",4,4); yes ---> a
// extendPalindrome("abaabcac",4,5); no --->bc

// output was 6

// madam //check for this
