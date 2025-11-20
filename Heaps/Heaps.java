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
    }
    public static void main(String[] args){
        
    }
}
