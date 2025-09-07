class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
}
class LinkedList{
    static Node head;
    static Node tail;
    void addinlist(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        
    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    void addlast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    void addfirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
}
public class ll{
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addfirst(12);
        list.addlast(13);
        list.addlast(14);
        list.display();
    }
}