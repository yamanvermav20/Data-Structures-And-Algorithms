import java.util.*;
public class Heaps {
    //Binary Treee
    //at most 2 children
    
    //Complete Binary Tree
    //CBT is a BT in which all the levels are completely filled except
    //possibly the last one, which is filled from left to right
    
    //Heap Order Property
    //Children >= Parent(minHeap)
    //Children <= Parent(maxHeap)
    
    //node index = i;
    // left child = 2 i + 1
    // right child = 2 i + 2
    
    //child --> parent
    //i --> (i - 1) / 2

    //this is mean heap just change sign >  < to alternate <  >  so it can be change to max heap
    public static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            // add at last index
            arr.add(data);
            int x = arr.size() - 1; // x is my child index
            int par = (x - 1) / 2;

            while(arr.get(x) < arr.get(par)){ //O(log N); as we are traversing through levels
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify (int i){ //O(log N)
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }
            
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }

        }

        //For 1st and last node swap
        // remove last index arr.remove(arr.size() - 1);
        // fix my heap function heapify 
        public int remove(){
            int data = arr.get(0);

            //step1 = swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            //step2 = delte last
            arr.remove(arr.size() - 1);

            //step3 - heapify
            heapify(0);
            return data;
        } 

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String[] args){
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while(!pq.isEmpty()){
            System.out.println(pq.peek()); 
            pq.remove();
        }
    }
}
