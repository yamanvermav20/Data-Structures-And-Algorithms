import java.util.*;

public class MissingRanges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read lower and upper bounds
        int lower = sc.nextInt();
        int upper = sc.nextInt();

        // Read size of the array
        int size = sc.nextInt();

        // Read array elements
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Add bounds and sort
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            if (num >= lower && num <= upper) {
                set.add(num);
            }
        }
        set.add(upper + 1); // To handle last range
        set.add(lower - 1); // To handle first range

        Integer prev = null;
        for (int num : set) {
            if (prev != null && num - prev > 1) {
                int start = prev + 1;
                int end = num - 1;
                System.out.println(start + " " + end);
            }
            prev = num;
        }

        sc.close();
    }
}
