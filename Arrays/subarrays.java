// package Basics;
import java.util.*;
public class subarrays {
    public static void subarray(int[]arr){
        int totalSubarrays=0;
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    System.out.print(arr[k]+" ");
                }
                totalSubarrays++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(" The total number of subarrays : "+ totalSubarrays);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        subarray(arr);
    }
}
