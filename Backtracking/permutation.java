public class permutation {
    public static void permutation(String str){
        backtrack(str, "");
    }
    public static void backtrack(String str, String result){
        if(str.length() == 0){
            System.out.println(result);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i + 1);
            backtrack(newstr, result + ch);
        }
    }
    public static void main(String[] args){
        String str = "hi";
        permutation(str);
    }
}
