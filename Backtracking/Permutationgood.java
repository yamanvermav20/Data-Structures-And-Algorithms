import java.util.*;
public class Permutationgood {
    public static permutation(String str, List<Character> list, List<String> result){
        for(int i = 0; i < str.length(); i++){
            list.contains(str.charAt(i)) continue;
            list.add(str.charAt(i) - '0');
            permutation(str, list, result);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        List<Character> list = new ArryList<>();
        List<String> result = new ArrayList<>();
        permutation(str, list, result);
    }
}
