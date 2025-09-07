// package Sorting;

// Best Case: O(n log n)    (pivot divides array evenly each time).
// Average Case: O(n log n)
// Worst Case: O(n²)

import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pidx = partition(arr, low, high);
            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);
        }
    }
    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        arr[high] = arr[i];
        arr[i] = pivot;
        return i;
    }
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int [n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        quickSort(arr, 0, n - 1);
        print(arr);
   
    }
}
