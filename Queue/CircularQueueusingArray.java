public class CircularQueueusingArray {
    public static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n){
            arr=new int[n];
            size=n;
            rear=-1;
            front=-1;
        }
        public static boolean isEmpty(){
            return rear == -1 && front==-1; 
        }
        public static boolean isFull(){
            return (rear + 1) % size == front;
        }
        //add
        public static void add(int data){ // Time Complexity is O(1) of addition;
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }

            //adding first element
            if(front == -1){
                front = 0; //to take it to first when inserting
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }
        public static int remove() { // Time Complexity is O(n) in remove in this case;
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }

            int result = arr[front]; 
            // last element delete
            if(rear == front) {
                rear = front = -1;
            }
            else {
                front = (front + 1) % size;
            }
            return result;

        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args){
        Queue q = new Queue(5);
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
