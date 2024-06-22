class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        if(a.equals(b)) return true;
        if(a.length()!=b.length()) return false;
        int[] arrA = new int[26];
        int[] arrB = new int[26];
        for(int i=0;i<a.length();i++){
            arrA[a.charAt(i)-'a']++;
            // arr[b.charAt(i)-'a']++;
        }
        //System.out.println(Arrays.toString(arrA));
        for(int i=0;i<b.length();i++){
            arrB[b.charAt(i)-'a']++;
        }
               // System.out.println(Arrays.toString(arrB));

        for(int i=0;i<26;i++){
            if(arrA[i]!= arrB[i]) return false;
        }
      
        return true;
        
    }
}
