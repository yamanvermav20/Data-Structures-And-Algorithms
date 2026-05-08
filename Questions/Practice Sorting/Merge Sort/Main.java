// package Practice Sorting.Merge Sort;

public class Main {
    //time complexity : O(nlogn) always
    //space complexity : O(n) 
    //Stable Sorting

    public static int[] mergeSort(int[] arr, int start, int end){
        if(start == end){
            return new int[]{arr[start]};
        }

        int mid = start + (end - start) / 2;
        int[] left = mergeSort(arr, start, mid);
        int[] right = mergeSort(arr, mid +  1, end);
        
        int[] merge = merge(left, right);
        
        return merge;
    }

    public static int[] merge(int[] left, int[] right){
        int[] temp = new int[left.length + right.length];

        int i = 0, j = 0;
        int index = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                temp[index++] = left[i++];
            }
            else{
                temp[index++] = right[j++];
            }
        }

        while(i < left.length){
            temp[index++] = left[i++];
        }
        while(j < right.length){
            temp[index++] = right[j++];
        }

        return temp;
    }

    public static int[] sort(int[] arr){
        return mergeSort(arr, 0, arr.length - 1);
    }
    public static void print(int[] arr){
        for(int i : arr) System.out.print(i + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = {4, 5, 23, 3 ,6, 4, 3, 56, 4};

        int[] sorted = sort(arr);
        print(sorted);
    }
}
