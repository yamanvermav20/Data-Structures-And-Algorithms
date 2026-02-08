//Question is we have a string where S means Student and . means empty you have to place router for
// each student so that each student get internet
// the router is only accessed by adjacent students
// return minimum number of routers required;
import java.util.*;
public class PlaceRoutersPlaySimple {
    public static int find(String str, boolean[] visited){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '.'){
                if(i > 0 && str.charAt(i - 1) == 'S' && !visited[i - 1] && i < str.length() - 1 && str.charAt(i + 1) == 'S' && !visited[i + 1]){
                    visited[i - 1] = true;
                    visited[i + 1] = true;
                    count++;
                }
            }
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '.'){
                boolean found = false;
                if(i > 0 && str.charAt(i - 1) == 'S' && !visited[i - 1]){
                    visited[i - 1] = true;
                    found = true;
                }
                if(i < str.length() - 1 && str.charAt(i + 1) == 'S' && !visited[i + 1]){
                    visited[i + 1] = true;
                    found = true;
                }
                if(found) count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        String str = "S.S..S.S.SS.";   //...
        String str2 = "S.S..S.S.SS.....S.S";  
        String str3 = "S.S.SS..S...S.S.S.S.S.SS.S.S";
         //.S.S       //SSSS     //S..S

        boolean[] visited = new boolean[str.length()];
        System.out.println("Minimum Routers " + find(str, visited));
        visited = new boolean[str2.length()];
        System.out.println("Minimum Routers " + find(str2, visited));
        visited = new boolean[str3.length()];
        System.out.println("Minimum Routers " + find(str3, visited));
    }
}
