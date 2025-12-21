public class HeapSort { //O(N Log N)
    //ascending ke liye max heap
    public static void heapify(int[] arr, int n, int i){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;
        if(left < n && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < n && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }
        if(maxIdx != i){
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
            heapify(arr, n, maxIdx);
        }
    }
    public static void heapSort(int arr[]){
        //step1 - build maxHeap
        int n = arr.length;
        for(int i = n/2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }

        // Build a max-heap → largest element is at arr[0].
        // Place this largest element at the END of the array.
        // Reduce heap size (ignore the last placed element).
        // Heapify again to get the next largest element at top.
        // Repeat.
        
        for(int i = n - 1; i >= 0; i--){
            //swap (largest - first) with last index
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 4, 5, 3};
        heapSort(arr);
        for(int x : arr){
            System.out.print(x + " ");
        }

    }
}
