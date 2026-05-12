// package Questions.Practice Sorting.Quick Sort;

public class Main {
    public static void quickSort(int[] arr, int start, int end){
        //time complexity : O(n2) worst case
        //time complexity : O(nlogn) average case
        //Space : O(log n) recursion stack
        //not stable 


        if(start >= end) return;
        int pidx = partition(arr, start, end);
        quickSort(arr, start, pidx - 1);
        quickSort(arr, pidx + 1, end);
    }
    public static int partition(int[] arr, int start, int end){
        int value = arr[end];

        int index = start - 1;
        for(int i = start; i < end; i++){
            if(arr[i] <= value){
                index++;
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        
        index++;
        int temp = arr[index];
        arr[index] = arr[end];
        arr[end] = temp;

        return index;
    }
    public static void sort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
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
