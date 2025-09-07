import java.util.*;
public class first {
    static class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
// static class BinaryTree{
    static int idx=-1;
    public static Node buildTree(int nodes[]){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node newNode=new Node(nodes[idx]);
        newNode.left=buildTree(nodes);
        newNode.right=buildTree(nodes);

        return newNode;
    }


// }
    public static void main(String[] args){
        int arr[] = {1, 2, 4,-1, -1, 5, -1, -1, 3, -1, 6, -1, -1}; // Proper binary tree input
       rightSideView(buildTree(arr));



    }
    
    public static void rightSideView(Node root) {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node a=q.remove();
            if(a==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }
            else{

                System.out.print(a.data+" ");
                if(a.left!=null)
                    q.add(a.left);

                if(a.right!=null)
                    q.add(a.right);

            }
        }
    
        
    }

    public static List<Integer> RightSideTree(Node root) {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node a=q.remove();
            if(a==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }
            else{
                if(a==null)
                System.out.print(a.data+" ");
                if(a.left!=null)
                    q.add(a.left);

                if(a.right!=null)
                    q.add(a.right);

            }
        }
    return null;
        
    }
}
