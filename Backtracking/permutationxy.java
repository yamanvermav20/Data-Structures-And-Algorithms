import java.util.*;

public class permutationxy {
    public static void permutation(int n, List<Character> list, List<String> result){
        if(list.size() == n){
            StringBuilder stb = new StringBuilder();
            for(char i : list){
                stb.append(i);
            }
            result.add(stb.toString());
            return;
        }
        list.add('x');
        permutation(n, list, result);
        list.remove(list.size() - 1);
        list.add('y');
        permutation(n, list, result);
        list.remove(list.size() - 1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Character> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        permutation(n, list, result);
        for(String str : result){
            System.out.println(str);
        }
    }
}
