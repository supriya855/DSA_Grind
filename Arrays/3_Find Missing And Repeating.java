class Solve {
    int[] findTwoElement(int arr[], int n) {
       int rep=0,miss=0;
       List<Integer> l = new ArrayList<>(n+1);
       for(int i=0;i<arr.length+1;i++){
           l.add(i,0);
       }
       for(int i=0;i<arr.length;i++){
           l.set(arr[i],l.get(arr[i])+1);
       }
      // System.out.println(l);
       for(int i=1;i<n+1;i++){
           if(l.get(i)==0)
           miss=i;
           if(l.get(i)==2)
           rep=i;
       }
       return new int[]{rep,miss};
    }
}
