INSERTION SORT => where it will sort the array in way that it consider the first element as sorted where it compares
  the othere elements and compare with first element and swaps like this goes
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



public class MergeSortWithTempArray {

    // The main function that sorts the given array
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int[] tempArray = new int[array.length];
        mergeSort(array, tempArray, 0, array.length - 1);
    }

    // Helper function to perform merge sort on a subsection of the array
    private static void mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Recursively sort the left half
            mergeSort(array, tempArray, left, middle);

            // Recursively sort the right half
            mergeSort(array, tempArray, middle + 1, right);

            // Merge the sorted halves
            merge(array, tempArray, left, middle, right);
        }
    }

    // Function to merge two sorted subarrays into a single sorted array
    private static void merge(int[] array, int[] tempArray, int left, int middle, int right) {
        // Copy the elements of the array into the temp array
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }

        int i = left;       // Initial index for the left subarray
        int j = middle + 1; // Initial index for the right subarray
        int k = left;       // Initial index to be sorted

        // Merge the temp arrays back into the original array
        while (i <= middle && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of the left subarray, if any
        while (i <= middle) {
            array[k] = tempArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of the right subarray, if any
        while (j <= right) {
            array[k] = tempArray[j];
            j++;
            k++;
        }
    }

    // Main function to test the merge sort implementation
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array:");
        printArray(array);

        mergeSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    // Utility function to print an array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
===========================================================

public class QuickSort {

    // The main function that sorts the given array
    public static void quickSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    // Helper function to perform quick sort on a subsection of the array
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, low, high);

            // Recursively sort the elements before and after partition
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Function to partition the array around the pivot
    private static int partition(int[] array, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = array[high];

        // Pointer for the greater element
        int i = low - 1;

        // Traverse through all elements and compare each with the pivot
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                // Swap if the element is smaller than the pivot
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the element at i+1 position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Return the index of the pivot element
        return i + 1;
    }

    // Main function to test the quick sort implementation
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array:");
        printArray(array);

        quickSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    // Utility function to print an array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}


// Merge Sort Using left[] right[]
public class MergeSort {

    // The main function that sorts the given array
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    // Helper function to perform merge sort on a subsection of the array
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Recursively sort the left half
            mergeSort(array, left, middle);

            // Recursively sort the right half
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Function to merge two sorted subarrays into a single sorted array
    private static void merge(int[] array, int left, int middle, int right) {
        // Calculate the sizes of the two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays to hold the subarrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data into the temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArray, if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArray, if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main function to test the merge sort implementation
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array:");
        printArray(array);

        mergeSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    // Utility function to print an array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

