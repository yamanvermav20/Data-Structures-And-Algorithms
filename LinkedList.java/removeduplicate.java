import java.util.Scanner;


class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class Lists{
    Node head;
    void add(int data){
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
    void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("null");
    }

    public Node duplicate2(Node head){
        Node temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int []arr=new int[size];
        temp=head;
        int k=0;
        while(temp!=null){
            arr[k]=temp.data;
            temp=temp.next;
            k++;
        }

        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(arr[i]==arr[j]){
                    arr[j]=-100;
                }
            }
        }
        Node newlist=new Node(arr[0]);
        Node ans=newlist;
        for(int i=1;i<size;i++){
            if(arr[i]!=-100){
            newlist.next=new Node(arr[i]);
            newlist=newlist.next;
            }
        }
        return ans;
    }

    public Node duplicate(Node head){
        Node temp=head;
        Node d=new Node(-1);
        Node anshead=d;
        while(temp!=null){
           Node  newList=anshead;
            int count=0;
            while(newList.next!=null){
                if(temp.data==newList.data){
                    count++;
                }
                newList=newList.next;
            }
            if(count==0){
                newList.next=new Node(temp.data);
                newList=newList.next;
            }
            temp=temp.next;

        }
        return d.next;
    }
    

}



public class removeduplicate {
    public static void main(String[] args){
        Lists ls=new Lists();
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();


        for(int i=0;i<a;i++){
            int element=sc.nextInt();
            ls.add(element);
        }
        System.out.println("List before ");
        ls.print();
        System.out.println();
        Node temp= ls.duplicate(ls.head);
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("null");
    }
}
