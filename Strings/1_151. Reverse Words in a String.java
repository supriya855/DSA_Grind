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
