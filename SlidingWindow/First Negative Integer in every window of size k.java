class Compute {    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] res = new long[N-K+1];
        int idx=0;
        ArrayList<Long> l = new ArrayList<>();
        int i=0,j=0;
        while(j<A.length){
            if(A[j]<0){
                l.add(A[j]);
            }
             if(j-i+1<K) {
                j++;
              }
            else if(j-i+1==K){
                if(l.size()==0) res[idx++]=0;
                else{
                res[idx++]=l.get(0);
                if(A[i]<0)//-8 2 3 -6 10 for this example at window (3,-6) ,
                //(-6,10) here i is points to the prev to 3 so we are not deleting to use for thi s window
                l.remove(l.get(0));
                }
                i++;
                j++;
                
            }
        }
        return res;
        
    }
}
