// package HackwithInfy Practice.SampleTest1;
// Question 1 EASY

// You want to buy food from a store. You have a scoring system that uses a unit called taste points.
// Each time you buy a type of food, you can measure its tastiness by the number of taste points you getfrom that food.
// You have N types of food. You can buy any type any number of times, as long as the total number of meals does not exceed M.
// However, you don't want to grow tired of a food if you buy it too often. Therefore, you will get v[i] − d[i] × (ti − 1) taste points when you buy the i-th type of food for the ti-th time.
// Find the maximum number of taste points you can achieve.

// Sample Test Cases
// Case 1
// Input:
// 1
// 1
// 5
// 2
// Output:
// 5
// Explanation:
// You can only buy the first food once and get 5 taste
// points.



import java.util.*;

public class Main {
    public static int backtrack(int[] v, int[] d, int N, int M, int index, int count, int[] countArr){
        if(count == M || index >= N){
            return 0;
        }
        
        int prev = v[index];
        v[index] = v[index] - d[index] * countArr[index];
        countArr[index]++;

        int left =  v[index] + backtrack(v, d, N, M, index, count + 1, countArr);
        countArr[index]--;
        v[index] = prev;

        int right = backtrack(v, d, N, M, index + 1, count, countArr);

        return Math.max(left, right);
    }

    public static int optimal(int N, int M, int[] v, int[] d){          //Greedy with heap O(M log N)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); //min heap -> maxheap
        int[] countArr = new int[N];

        int count = 0;
        int ans = 0;

        for(int i = 0; i < N; i++){
            countArr[i]++;
            pq.offer(new int[]{v[i], i});
        }

        while(!pq.isEmpty()){
            int[] values = pq.poll();

            int value = values[0];
            int index = values[1];

            ans += value;

            pq.offer(new int[]{v[index] - d[index] * countArr[index], index});

            count++;
            if(count == M) break;
        }

        return ans;
    }   

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //Total no of types
        int M = sc.nextInt();   //Total no of meals;

        int[] v = new int[N];
        int[] d = new int[N];

        for(int i = 0; i < N; i++){
            v[i] = sc.nextInt();
        }
        for(int i = 0; i < N; i++){
            d[i] = sc.nextInt();
        }

        int[] countArr = new int[N];

        int[][] dp = new int[N][M];
        for(int i[] : dp) Arrays.fill(i, -1);

        // System.out.println(backtrack(v, d, N, M, 0, 0, countArr));
        System.out.println(optimal(N, M, v, d));

    }
}
