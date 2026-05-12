// package Questions.Practice Sorting.Heap Sort;

public class Main {
    public static void heapify(int[] arr, int i, int n){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        int max = i;
        if(left < n && arr[left] > arr[max]){
            max = left;
        }
        if(right < n && arr[right] > arr[max]){
            max = right;
        }
        
        if(max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        
            heapify(arr, max, n);            
        }
    }
    public static void sort(int[] arr){
        int n = arr.length;

        for(int i = (n / 2) - 1; i >= 0; i--){
            heapify(arr, i, n);
        }

        for(int i = n - 1; i >= 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }
    public static void print(int[] arr){
        for(int i : arr) System.out.print(i + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = {4, 5, 23, 3 ,6, 4, 3, 56, 4};

        sort(arr);
        print(arr);
    }
}
