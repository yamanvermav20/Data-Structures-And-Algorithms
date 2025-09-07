public class array {

    public static void checkArray(int arr[],int i,int val){
        //base case
        if(i == arr.length){
            printArray(arr);
            return ;
        }
        //recursive case
        arr[i] = val;
        checkArray(arr,i + 1,val + 1);
        arr[i] = arr[i] - 2;

    }
    public static int[] printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return arr;
        
    
    }
    public static void main(String []args){
        int arr[]=new int[10];
        checkArray(arr,0,1);
        printArray(arr);
    }
}
