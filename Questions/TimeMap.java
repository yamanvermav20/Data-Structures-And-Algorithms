import java.util.*;

public class TimeMap {

    class Pair{
        String value;
        int timeStamp;

        Pair(String value, int timeStamp){
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    HashMap<String, List<Pair>> map;

    public TimeMap(){
        map = new HashMap<>();
    }

    public void set(String key, String value, int timeStamp){
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timeStamp));

    }
    public String get(String key, int timeStamp){
        
        if(!map.containsKey(key)) return "";
        
        List<Pair> list = map.get(key);
        String possibleValue = "";
        if(list.size() == 0) return "";


        int start = 0;
        int end = list.size() - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(list.get(mid).timeStamp <= timeStamp){
                possibleValue = list.get(mid).value;
                start = mid + 1;
            }
            else{
                end = mid + 1;
            }
        }

        return possibleValue;
    }

    public static void main(String[] args){
        TimeMap obj = new TimeMap();

        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));
    }
}
