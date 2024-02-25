

// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int k=pat.length();
    int i=0,j=0,subcount=0;
    while(j<txt.length()){
        if(j-i+1<k) j++;
        else if(j-i+1==k){
            int count=0;
            for(int x=0;x<k;x++){
                for(int y=i;y<i+k;y++){
                    if(txt.charAt(y)==pat.charAt(x)){
                        count++;
                        break;
                    }
                }
            }
           // System.out.println(count);
            if(count==k) subcount++;
            i++;
            j++;
        }
        
    }
    return subcount;
    }
}
