import java.util.*;
public class Priority_Queue {
    public static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args){
        //1, 2, 3, 4, 5
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq3 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Student> pq2 = new PriorityQueue<>();
        
        // pq.add(3);
        // pq.add(2); //O(log n)
        // pq.add(6); //O(log n)
        // pq.add(1); //O(log n)
        // pq.add(2); //O(log n)

        pq2.add(new Student("A", 3));
        pq2.add(new Student("B", 53));
        pq2.add(new Student("C", 37));
        pq2.add(new Student("D", 73));
        pq2.add(new Student("E", 33));

        while(!pq2.isEmpty()){
            System.out.println(pq2.peek().name + "-> " + pq2.peek().rank); //O(1);
            pq2.poll(); //O(log n);
        }
    }
}
