INSERTION SORT => where it will sort the array in way that it consider the first element as sorted where it compares the othere elements and compare with first element and swaps like this goes
// pseudo code
for(int i=1;i<nums.length;i++){
  int key = nums[i];
  int j = i-1;
  while(j>=0 && arr[j]>key){
    arr[j+1]= arr[j];
    j=j-1;
}
  arr[j+1]= key;
}
}


SELECTION SORT :  here we will sort the array based we will find the smallest element replace with its respective indicies
for(int i=0;i<nums.length;i++){
  int minIdx = i;
  for(int j =i+1;j<nums.length;j++){
  if(arr[j] <arr[minIdx]){
    minIdx = j;
  }
}
  int temp = arr[minIdx];
  arr[minIdx]=arr[i];
  arr[i]= temp;
}

BUBBLE SORT => it will swap the element untill the large element pops out to the right

for (int i=0;i<n;i++){
boolean swapped = false;
  for(int j=0;j<n-i-1;j++){// n-i-1 after every iteration last element at right so we are not considering that for again checks
    if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            swapped = true;
        }
 }
  if(swapped == false) break; or !swapped
}
    



