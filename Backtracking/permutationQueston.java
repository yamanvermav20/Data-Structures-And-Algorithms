import java.util.*;
public class permutationQueston {
    public static void permutation(String str, char ch, int index, List<String> result,  List<Character> list){
        if(list.size() == str.length()){
            StringBuilder stb = new StringBuilder();
            for(char i : list){
                stb.append(i);
            }
            result.add(stb.toString());
            return;
        }
        for(int i = 0; i < str.length(); i++){
            if(list.contains(str.charAt(i)) ) continue;
            list.add(str.charAt(i));
            permutation(str, ch, index, result, list);
            list.remove(list.size() - 1);

        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = sc.nextLine().charAt(0);
        int index = sc.nextInt();
        List<String> result = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        permutation(str, ch, index, result, list);
        // for(String i : result){
        //     String strr = i;
        //     if(strr.charAt(index) == ch){
        //         continue;
        //     }
        //     System.out.println(i);
        // }
        for(int i = 0; i < result.size(); i++){
            String strr = result.get(i);
            if(strr.charAt(index) == ch){
                result.remove(i);
                i--;
            }

        }
        for(String i : result){
            System.err.println(i);
        }
        sc.close();
    }
}


//gcd
//circular subarray sum
//next minus current;