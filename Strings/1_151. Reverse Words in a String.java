==============================================================
// it took 20sec
class Solution {
    public String reverseWords(String s) {
        List<String> l = new ArrayList<>();
        String res="";
        String str="";
        int count=0;
        for(int i=0;i<s.length();i++){
            count=0;
             if(s.charAt(i)!=' '){
               str+=s.charAt(i);
             }
            else if(s.charAt(i)==' '){
                count++;
                if(count==1){
                    if(!(str.equals("")))
                    l.add(str);
            }
             str="";
            }
        } 
        if(!str.equals("")) l.add(str); // the str value will be stored for last as no space at end it will not go to the else if
        //so again we are checking for the last word
       // System.out.println(l+" "+l.size()+" "+s.length());
        for(int i=l.size()-1;i>=0;i--){
            res+=l.get(i);
            if(i!=0)
            res+=' ';
        }
        return res;
    }
}
=========================================================================
    class Solution {
    public String reverseWords(String s) {
        if(s==null) return s;
        char[] ch = s.toCharArray();
        int n= ch.length;
        // step-1: reverse the whole string
        reverse(ch,0,n-1);
        //step-2:reverse each word
        reverseword(ch,n);
        //step-3: to remove extra spaces
        return cleanSpace(ch,n);
    }
    public void reverseword(char[] ch,int n){
        int i=0,j=0;
            while(i<n){
                while(i<j||(i<n&&ch[i]==' ')) i++;//counting space
                while(j<i||(j<n&&ch[j]!=' ')) j++;// counting non space ones
                reverse(ch,i,j-1);// so from after space to before the space of every word we are reverseing it
            }
    }
    public void reverse(char[] ch,int s,int e){
        while(s<e){
            char temp=ch[s];
            ch[s]=ch[e];
            ch[e]=temp;
            s++;
            e--;
        }
       //  System.out.println(Arrays.toString(ch));
    }
    public String cleanSpace(char[] ch ,int n){
        int i=0,j=0;
        while(i<n){
            while(i<n&&ch[i]==' ') i++;// skip the space 
            while(i<n&&ch[i]!=' ') ch[j++]=ch[i++];// keeping every non space one
            while(i<n&&ch[i]==' ') i++;
        if(i<n) ch[j++]=' ';//assining only one space
        }
        return new String(ch).substring(0,j);
    }

}
