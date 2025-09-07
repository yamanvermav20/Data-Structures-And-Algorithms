/**  important  **/
/*    Deque and Dequeue are different
 *    Deque means double ended queue
 *    where as dequeue means operation dequeue on queue 
 */

import java.util.*;
public class Deque_Double_Ended_Queue {
    public static void main(String []args){
        Deque<Integer> deque= new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(5);
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
        deque.addFirst(100);
        System.out.println(deque);


        
        System.out.println("first ele = "+ deque.getFirst());
        System.out.println("first ele = "+ deque.getLast());
    }
    
}
// we can also use deque for making queue class and stack class
// just make a queue or stack class and implement the operations of deque in their functions