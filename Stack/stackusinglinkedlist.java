import java.util.*;
public class stackusinglinkedlist {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Stack{
        static Node head=null;

        public static boolean isEmpty(){
            return head==null;
        }

        public static void push(int data){
            Node a=new Node (data);
            if(isEmpty()){
                head=a;
                return;
            }
            a.next=head;
            head=a;
    
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int top=head.data;
            return top;
        }
    }
    public static void main(String [] args){
        Stack st=new Stack();
        st.push(3);
        st.push(4);
        st.push(40);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.peek());
    }

}
