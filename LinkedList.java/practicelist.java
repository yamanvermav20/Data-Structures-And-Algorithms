class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class linkedlist{
    static Node head;
    static Node tail;
    void addinlist(int data){
        Node a=new Node(data);
        if(head==null){
            head=a;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=a;
        }
    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");

    }
    void addlast(int data){
        Node a=new Node(data);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=a;
        a.next=null;
    }

    void addfirst(int data){
        Node a=new Node(data);
       
        if(head==null){
            head=a;
        }
        else{
            a.next=head;
            head=a;
        }
    }

}
public class practicelist {
    public static void main(String[] args){
        linkedlist l=new linkedlist();
        l.addinlist(23);
        l.addinlist(33);
        l.addinlist(43);
        l.addinlist(53);
        l.addinlist(63);
        l.addfirst(3);
        l.addlast(3444);
        l.addlast(4);
        l.display();

    }
    
}
