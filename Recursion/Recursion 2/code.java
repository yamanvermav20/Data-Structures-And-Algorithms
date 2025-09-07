import java.util.*;
public class code {
    
    // public static void checkIndex(int arr[],int i,int key){
    //     if(i==arr.length){
    //         return;
    //     }
    //     if(arr[i]==key){
    //         System.out.print(i+" ");
    //     }
    //     checkIndex(arr,i+1,key);

    // }

    // public static int checkLength(String str){
    //     if(str.equals("")){
    //         return 0;
    //     }
    //     return 1+checkLength(str.substring(1));

    // }

    public static String removeDuplicates(String str,int i,boolean[] arr, StringBuilder newStr){
        //only for a-z ,no " " or special character allower;

        if(i==str.length()){
            return newStr.toString();
        }
        int index=str.charAt(i)-'a';
        if(arr[index]!=true){
            newStr.append(str.charAt(i));
        arr[index]=true;
        }
    
        return removeDuplicates(str, i+1,arr,newStr);

    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);


        // int a=sc.nextInt();

        // int arr[]=new int[a];
        // for(int i=0;i<a;i++){
        //     arr[i]=sc.nextInt();
        // }
        // System.out.println("Enter element you want to check index:");
        // int b=sc.nextInt();
        // checkIndex(arr,0,b);


        // String str=sc.nextLine();
        // System.out.println(checkLength(str));
        

        String str=sc.nextLine();
        System.out.println(removeDuplicates(str, 0, new boolean[26], new StringBuilder()));
    }
}




