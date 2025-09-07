import java.util.*;
public class firstandlast {
    public static int firstoccurence(int arr[],int num){
        int start=0,end=arr.length-1;
        int index=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==num){
                index=mid;
                end=mid-1;                                               
            }
            else if(arr[mid]<num){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
            
        }
        return index;
    }

    public static int lastoccurence(int arr[],int num){
        int start=0,end=arr.length-1;
        int index=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==num){
                index=mid;
                start=mid+1;
            }
            else if(arr[mid]<num){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return index;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int arr[]=new int[a];
        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
        }
        
        int num=sc.nextInt();
        System.out.print("First Occurence :");
        System.out.println(firstoccurence(arr,num));

        System.out.print("Last Occurence :");
        System.out.println(lastoccurence(arr,num));
    }
}


