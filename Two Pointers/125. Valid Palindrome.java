/*Question is saying the you are given it can consists of any characters and numbers and special charcters 
  =>if the input has any Capital letters you need to conevert to small (that can be done adding 32 to that char)
  =>after that avoid specical charcaters and check for the valid palindrome or not*/
  
class Solution {
    public boolean isPalindrome(String s) {
        //Convert all the uppercase letters into lowercase
        //remove any extra characters other than alphabets
        char[] ch =s.toCharArray();
        String str="";
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='A'&&ch[i]<='Z'){
                ch[i]=(char)(ch[i]+32);
                str+=ch[i];
            }
            else if(ch[i]>='a'&&ch[i]<='z'){
                str+=ch[i];
            }
            else if(ch[i]>='0'&&ch[i]<='9')
             str+=ch[i];
        }
       //System.out.println(str);
       boolean res= isPalind(str);
       return res;
    }
    public boolean isPalind(String str){
        int s=0,e=str.length()-1;
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e))
            return false;
            s++;
            e--;
        }
        return true;
    }

}
// its time complexity O(length of string)=>O(N)
