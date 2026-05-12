public class Main{
    public static void sort(int[] arr){
        //Time complexity = O(n) best case 
                        //   = O(n2) worst case;
        //Space = O(1);
        //❌ not stable algorithm : means preserve teh relative order of equal elements
        //[(4a), (4b), (3)]
        //At i = 0, minIndex becomes 2 (value = 3).
        //Swap arr[0] with arr[2].
        //Result: [3, 4b, 4a].

        for(int i = 0; i < arr.length; i++){
            boolean swap = false;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if(!swap) break;
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
