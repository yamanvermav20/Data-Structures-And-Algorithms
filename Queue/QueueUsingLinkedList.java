import java.util.*; //we can also directly import pakcage of queue

// Queue<Integer> q = new LinkedList<>();
//queue is a interface not a class so we cannot directly made its object
// we use linkedlist on the right side to use queue 

//Queue<Integer> q = new ArrayDeque<>();
//we can also make this with ArrayDeque 

// complexity of all above is O(1);
public class QueueUsingLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    } 
    //O(1) complexity for add remove and peek
    static class Queue{
        static Node head=null;
        static Node tail=null;
        public static boolean isEmpty(){
            return head ==null && tail == null;
        }
        public static void add(int data){
            Node newNode = new Node (data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.next = newNode;
            tail=newNode;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int front=head.data;
            if(tail==head){
                tail = head = null;
            }
            else{
                head=head.next;
            }
            return front;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return head.data;
        }
    
    }
    public static void main(String[] args){
         Queue q = new Queue();
        q.add(2);
        q.add(3);
        q.add(5);
        System.out.println(q.remove());
        q.add(8);
        System.out.println(q.peek());
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
