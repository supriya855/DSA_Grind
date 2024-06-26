import java.util.Scanner;
class HelloWorld {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int[] arr = new int[n];
int x = 14;
for(int i=0;i<n;i++){
    arr[i]=sc.nextInt();
}
 int res = findFirstOccurence(arr,x);
 System.out.println(res);
    }

public static int findFirstOccurence(int[] arr, int x){
int s=0, e= arr.length-1;
boolean isFlag = false;
if(arr[s]==x) return s;
    while(s<=e){
        int mid = (s+(e-s)/2);
        if(arr[mid]==x){
              isFlag = true;
            if((mid-1>0 && mid-1<arr.length-1 && arr[mid-1]!=x) || s==e){
                // System.out.println(mid);
                return mid;
            }
            else{
                e= mid;
            }
          
        }
        else if(arr[mid]<x) s= mid+1;
        else e = mid;
        
    }
    if(isFlag)
    return s;
    else // if X is not present
    return -1;
  }
}



============================================================(same intution easy clean written)===============================================
    
public static int findFirstOccurence(int[] arr, int x){
int s=0, e= arr.length-1;
int start = -1;
if(arr[s]==x) return s;
    while(s<=e){
        int mid = (s+(e-s)/2);
        if(arr[mid]==x){
              start= mid;
              e= mid-1;
        }
        else if(arr[mid]<x) s= mid+1;
        else e = mid-1;
    }
    return start;
  }
}// just here they maintained one start variable
