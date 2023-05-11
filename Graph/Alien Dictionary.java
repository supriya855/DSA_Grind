class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        
        String res="";
        for(int i=0;i<N-1;i++){
            String s1=dict[i];
            String s2= dict[i+1];
            int min=Math.min(s1.length(),s2.length());
            for(int j=0;j<min;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                     adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                     break;
                    //set.add(s1.charAt(j));
                }
            }
        }// graph is ready
        List<Integer> list = topoSort(K,adj);
        for(int i:list){
            res+=(char)(i+'a');
        }
        return res;
    }
    public List<Integer> topoSort(int K, List<List<Integer>> adj){
        int[] indegree= new int[K];
        for(int i=0;i<K;i++){
            for(int adjNode:adj.get(i)){
                indegree[adjNode]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<K;i++){
            if(indegree[i]==0)
            q.add(i);
        }
        while(!q.isEmpty()){
            int val =q.poll();
            list.add(val);
            for(int i:adj.get(val)){
                indegree[i]--;
                if(indegree[i]==0) q.add(i);
            }
        }
        return list;
    }
}
//here for always for every input it returns correct order but for the inputs like
/*
input -1:
abcd
abc 
here longest string is first the second string so this invalid 
input- 2:
abc
bca
adf
here we have cycle this also invalid a-> b
b->a 
