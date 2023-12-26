//BRUTE FORCE
class Solution {
    public String reverseVowels(String st) {
        if(st==" ") return st;
        char[] s = st.toCharArray();
        List<Character> l = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'||s[i]=='A'||s[i]=='E'||s[i]=='I'||s[i]=='O'||s[i]=='U'){
                l.add(s[i]);
                s[i]='/';
            }
        }
        Collections.reverse(l);
      //  System.out.println(l)
        int idx=0;
        for(int i=0;i<s.length;i++){
            if(s[i]=='/'&&l.size()>=1){
                s[i]=l.get(idx++);
            }
        }
        String str="";
      for(int i=0;i<s.length;i++){
          str+=s[i];
      }
    return str;
    }
}

''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
class Solution {
    public String reverseVowels(String s) {
        int st=0,e=s.length()-1;
        char[] ch = s.toCharArray();
        String str="aeiouAEIOU";
        while(st<e){
        while(st<e && str.indexOf(ch[st])==-1){// indexOf return -1 untill it founds vowel charcter here
            st++;// until found any vowel start pointer
        }
        while(st<e && str.indexOf(ch[e])==-1){
            e--;
        }

                char c=ch[st];
                ch[st]=ch[e];
                ch[e]=c;
               st++;
               e--;
        }
        String string = new String(ch);
        return string;
    }
    
}
