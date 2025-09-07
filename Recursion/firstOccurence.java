import java.util.*;
public class firstOccurence {

    public static void firstOccuring(int [] arr,int i,int key){
        if(i==arr.length){
            System.out.println( -1);
            return;
        }
        if(arr[i]==key){
            System.out.println( i);
            return;
        }
         firstOccuring(arr,i+1,key);
    }

    public static int firstOccur(int []arr,int i,int key){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccur(arr,i+1,key);
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


        System.out.println(firstOccur(arr,0,b));
        
        firstOccuring(arr,0,b);
    }
}
