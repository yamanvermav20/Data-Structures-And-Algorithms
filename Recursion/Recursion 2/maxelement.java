import java.util.*;
public class maxelement {
    public static int maximum(int[] arr,int i){
        if(i==0){
            return arr[i];
        }
        if(arr[i-1]<arr[i] ){
            arr[i-1]=arr[i];
        }
        return maximum(arr,i-1);
    }
    public static int sum(int []arr,int i){
        if(i==0){
            return arr[i];
        }
        return arr[i]+sum(arr,i-1);
    }
    public static int maxSum2(int array[],int i){
        if(i==0){
            return array[i];
        }
       int b= maxSum2(array,i-1);
        if(array[i]<b){
            return b;
        }
        return array[i];
    }

    public static void even(int i,int n,int count){
        if(n==count){
            return;
        }
        if(i%2==0){
            System.out.print(i+" ");
            count++;
        }
        even(i+1,n,count);

    }
    public static void checkIndex(int arr[],int i,int key){
        if(i==arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.print(i+" ");
        }
        checkIndex(arr,i+1,,key);

    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int arr[]=new int[a];
        int b=sc.nextInt();
        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
        }
        //even(2,a,0);
    }
}
