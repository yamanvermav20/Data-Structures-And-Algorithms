package Sorting;

// Time Complexity:
// Best: O(n) (already sorted)
// Worst: O(n²)
// Space Complexity: O(1)
//Insertion Sort picks one element and inserts it into its correct position in the sorted part of the array.
//it start from that element index to 0 index because it push other elements greater than key to right side and then push the key at most left where it has to be placed


import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
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
        insertionSort(arr);
        print(arr);
   
    }
}
