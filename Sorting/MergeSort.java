package Sorting;

// Time Complexity: O(n log n) (all cases)
// Space Complexity: O(n) (extra array for merging)

import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= high){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid) temp[k++] = arr[i++];
        while(j <= high)    temp[k++] = arr[j++];
        for(k = 0, i = low; k < temp.length; k++, i++){
            arr[i] = temp[k];
        }
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
        mergeSort(arr, 0, n - 1);
        print(arr);
   
    }
}
