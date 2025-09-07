import java.util.*;
public class englishtoDigit{
    public static String digittoenglish(int a,StringBuilder strr){
        String []arr={"zero ","one ","two ","three ","four " ,"five ","six ","seven ","eight ","nine "};
        if(a==0){
            return strr.toString();
        }
        digittoenglish(a/10,strr);
        strr.append(arr[a%10]);
        return strr.toString();
        
        

    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println(digittoenglish(a,new StringBuilder()));
    }
}

