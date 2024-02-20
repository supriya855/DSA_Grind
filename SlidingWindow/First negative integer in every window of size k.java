class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
       ArrayList<Long> list = new ArrayList<>();
        int idx=0;
        for(int i=0;i<=A.length-K;i++){
            int count=0;
            for(int j=i;j<i+K;j++){
                if(A[j]<0){
                    list.add(A[j]);//first negative
                    break;
                }
                count++;
            }
             if(count==K) {
                   list.add(A[i]*0);//just to add 0 here
             }
        } 
         long[] res = new long[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
