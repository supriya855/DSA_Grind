public class Solution {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList();
        int i=0,j=0,max=Integer.MIN_VALUE,maxi=Integer.MIN_VALUE,maxBoth =Integer.MIN_VALUE;
        while(j<A.size()){
            max=Math.max(max,A.get(j));
            if(j-i+1<B){
                j++;
            }
            else if(j-i+1==B){
                res.add(max);
                max = Integer.MIN_VALUE;
                i++;
                j++;
                
            }
        }
        return res;
    }
}
// A = [1, 3, -1, -3, 5, 3, 6, 7]
//     B = 3

// A : [ 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 ]
// B : 2
