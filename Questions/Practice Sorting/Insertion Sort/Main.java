// package Practice Sorting.Insertion Sort;
//insert key at correct position
public class Main {
    public static void sort(int[] arr){
        //time complexity = O(n); best case and also best when array is nearly sorted
        //                  = O(n2) square worst case time complexity
        //space complexity = O(1)
        //stable algorithm : means preserve teh relative order of equal elements

        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int key = arr[i];
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
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
