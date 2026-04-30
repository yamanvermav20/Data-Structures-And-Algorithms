// Problem 1: Merge Intervals
// 📌 Problem Description

// You are given an array of intervals where each interval is represented as [start[i], end[i]].

// Merge all overlapping intervals.
// Return an array of the non-overlapping intervals that cover all the intervals in the input.
// 📥 Input Format
// First line: integer n (number of intervals)
// Next n lines: two integers start and end

import java.util.*;

public class Main {

    public static List<List<Integer>> merge(List<List<Integer>> intervals) {
        // Write Your Code Here
        Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));

        List<List<Integer>> ans = new ArrayList<>();
        int start = intervals.get(0).get(0);
        int end = intervals.get(0).get(1);

        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).get(0) <= end){
                end = Math.max(end, intervals.get(i).get(1));
            }
            else{
                ans.add(Arrays.asList(start, end));
                start = intervals.get(i).get(0);
                end = intervals.get(i).get(1);
            }
            
        }
        ans.add(Arrays.asList(new Integer[]{start, end}));
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<List<Integer>> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            intervals.add(Arrays.asList(start, end));
        }

        List<List<Integer>> ans = merge(intervals);

        for (List<Integer> interval : ans) {
            for (int num : interval) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}