import java.util.*;
public class good{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();       
        sc.nextLine();
        String arrji[]=new String[a];
        for(int i=0;i<a;i++){
             arrji[i]=sc.nextLine();
        }
        int arr[]=new int[a];
        for(int i=0;i<a;i++){
             arr[i]=Integer.valueOf(arrji[i]);
        }
        String []str=new String[a];
        for(int i=0;i<a;i++){
            str[i]=String.valueOf(arr[i]);
        }
        Arrays.sort(str, (x,y)-> (y+x).compareTo(x+y));
        if(str[0].equals("0")){
            System.out.println("0");
            return;
        }
        StringBuilder stb= new StringBuilder();
        for(int i=0;i<a;i++){
            stb.append(str[i]);
        }
        System.out.println(stb);
        
    }
}