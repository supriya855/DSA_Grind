
O(LogN+LogN) = O(logN)
class Solution {
    public int[] searchRange(int[] arr, int target) {
        int firstIdx = binarySearchFirst(arr, target);
        int lastIdx = binarySearchLast(arr, target);
        return new int[] { firstIdx, lastIdx };
    }

    public int binarySearchFirst(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        int start = -1;
        while (s <= e) {
            int mid = (s + (e - s) / 2);
            if (arr[mid] == target) {
                start = mid;
                e = mid - 1;

            } else if (arr[mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return start;
    }

    public int binarySearchLast(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        int end = -1;
        while (s <= e) {
            int mid = (s + (e - s) / 2);
            if (arr[mid] == target) {
                end = mid;
                s = mid + 1;
            } else if (arr[mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return end;
    }
}
