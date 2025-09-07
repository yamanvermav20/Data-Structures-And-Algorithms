import java.util.*;
public class hello {
    public static void functions(int a){ //counting steps until the number become a single digit;
        int b,sum=a,count=0;
        while(sum>10){
            int c=0;
            while(sum>0){
                b=sum%10;
                c+=b;
                sum=sum/10;
            }
            sum=c;
            count++;

        }
        System.out.println(count);
        
    }
    public static boolean balancedParanthesis(String str){
        Stack<Character> stt=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{'){
                stt.push(str.charAt(i));
            }
            else if(str.charAt(i)==')'){
                if(stt.empty() || stt.pop()!='('){
                    return false;
                }
                
            }
            else if(str.charAt(i)=='}'){
                if(stt.empty() || stt.pop()!='{'){
                    return false;
                }
                
            }
            else if(str.charAt(i)==']'){
                if(stt.empty() || stt.pop()!='['){
                    return false;
                }
                
            }
        }
        if(stt.empty())
        return true;
        return false;
    }
    public static int  garden(int [] arr){ // code for maximise the result(arr[0]+arr[last]) by swapping any 1 of the first and last;
        int length=arr.length;
        int start=arr[0];
        int end=arr[length-1];
        int max=Math.min(start,end);
        int a=Math.max(start,end);
        
        for(int i=1;i<length-1;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return a+max;
    }

    public static void printArray(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void sorting(int [] arr){ // code for sorting array containing only 0 1 2;
        int count0=0,count1=0,count2=0;
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count0++;
            }
            else if(arr[i]==1){
                count1++;
            }
            else{
                count2++;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(count0>0){
            ans[i]=0;
            count0--;
            }
            else if(count1>0){
                ans[i]=1;
                count1--;
            }
            else{
                ans[i]=2;
            }
        }
        printArray(ans);

    }

    public static int  checknumber(int arr[]){
        int total=0;
        for(int i=0;i<arr.length;i++){
            total+=arr[i];
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            int a=total-arr[i];
            if(arr[i]==0){
                System.out.println("java.lang.ArithmeticException: / by zero");
                return 0;
            }
            else if(a%arr[i]==0){
                count++;
            }
        }
        return count;
    }

    public static void productArray(int arr[]){ // product array ignoring self
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int product=1;
            for(int j=0;j<arr.length;j++){
                if(i==j){
                    continue;
                }
                product*=arr[j];
            }
            ans[i]=product;
        }
        printArray(ans);
    }

    public static void Array(int []arr){
        
    }

    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        // Stack<Integer> stt=new Stack<>();
        int arr[]=new int[a];
        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
            // stt.push(arr[i]);
        }
        // int i=0;
        // while(!stt.empty()){
        //     arr[i]=stt.pop();
        //     i++;
        // }
        // printArray(arr);



        // System.out.println();
        // int number=sc.nextInt();
        // functions(number);
        
        

        // String str=sc.nextLine();
        // System.out.println(balancedParanthesis(str));

        // System.out.println(garden(arr));

        // sorting(arr);

        // System.out.println(checknumber(arr));

        productArray(arr);
    }
}
