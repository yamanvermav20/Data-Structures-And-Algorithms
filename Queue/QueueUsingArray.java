public class QueueUsingArray {
    public static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n){
            arr=new int[n];
            size=n;
            rear=-1;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }
        public static boolean isFull(){
            return rear == size - 1;
        }
        //add
        public static void add(int data){ // Time Complexity is O(1) of addition;
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }
        public static int remove() { // Time Complexity is O(n) in remove in this case;
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }

            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear = rear - 1;
            return front;

        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String[] args){
        Queue q = new Queue(5);
        q.add(2);
        q.add(3);
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}       
