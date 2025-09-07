public class stackusingarray {
    public static class Stack{
        private int arr[];
        private int top;
        private int length;

    public  Stack(int size){
        arr=new int[size];
        length=size;
        top=-1;
    }
    public void push(int data){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }
        arr[++top]=data;
        
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        return arr[top];
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow! No element to pop.");
            return 0;
        }
        int data= arr[top];
        top--;
        return data;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==length-1;
    }
}
public static void main(String [] args){
    Stack stack=new Stack(5);
    stack.push(1);
    stack.push(2);
    System.out.println(stack.pop());
    stack.pop();
    

}
    
}
