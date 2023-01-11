/*
Q-1: Print All subsequences 
Subsequences: A contigious/ non contigious which follows the order
For Example: [1,2,3]
[1],[2],[3],[1,2],[3,1],[3,2],[3,1,2]
Approach: pick and non pick
Algorithm:
step1: Take a list which we can add subsequnces
step2: call a function which takes index and list and arr
step2: add the elements in list increment index and call the function again
step3: call the function and remove the element from the list
step-4 return all elements when index reaches length of an array
                                                         fun(arr,0,0)
                                                    /                  \
                                     fun(arr,[1],1)                                 fun(arr,[],1)
                                   /              \                                  /              \
                  fun(arr,[1,2],2)           fun(arr,[1],2)                fun(arr,[2],2)             fun(arr,[],2)
              /            \                 /         \                 /                \              /          \    
fun(arr,[1,2,3],3)   fun(arr,[1,2],3)  fun(arr,[1,3],3) fun(arr,[1],3)  fun(arr,[2,3],3) fun(arr,[2],3) fun(arr,[3],3) fun(arr,[],3)   
*/
public class Subseq {
    public static void main(String[] args){
        int[] arr={3,1,2};
        List<Integer> l= new ArrayList<>();
        fun(arr,l,0);
    }
    public static void fun(int[] arr,List<Integer> l,int ind){
        if(ind>=arr.length){
                System.out.println(l);
                return;
        }
        fun(arr,l,ind+1);// pick the element
        l.add(arr[ind]);
        fun(arr,l,ind+1);// not pick the element
        l.remove(l.size()-1);// here you are backtraking to remove last element from the list

    }
}


