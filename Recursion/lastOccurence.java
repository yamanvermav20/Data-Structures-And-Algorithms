import java.util.Scanner;

public class lastOccurence {
    public static int lastOccur(int arr[],int key,int i){
        if(i==-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return lastOccur(arr,key,i-1);
    }

    public static int lastOccur2(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        int isFound=lastOccur2(arr,key,i+1);
        if(isFound==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int[] arr=new int[5];
        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
        }      
        System.out.println("enter the key you want to find:")  ;
        int b=sc.nextInt();


       System.out.println(lastOccur2(arr,b,0));

    }
}
