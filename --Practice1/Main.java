import java.util.*;
public class Main {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int index=-1;
        public static Node Buildtree(int[] nodes){
            index++;
            if(nodes[index]==-1){
                return null;
            }
            Node newNode=new Node(nodes[index]);
            newNode.left=Buildtree(nodes);
            newNode.right=Buildtree(nodes);
            return newNode;
        }
        public static void preorder(Node root){ //O(n)
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        public void levelorder(Node root){
            Queue<Node> queue=new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while(!queue.isEmpty()){
                Node curr=queue.remove();
                if(curr==null){
                    System.out.println();
                    if(queue.isEmpty()){
                        break;
                    }
                    else{
                        queue.add(null);
                    }
                }
                else{
                    System.out.print(curr.data+" ");
                    if(curr.left!=null){
                        queue.add(curr.left);
                    }

                    if(curr.right!=null){
                        queue.add(curr.right);
                    }
                }
            }
        }
        public int height(Node root){
            if(root==null){
                return 0;
            }
            int left=height(root.left);
            int right=height(root.right);
            return 1+Math.max(left,right);
        }
        public int sum(Node root){
            if(root==null){
                return 0;
            }
            return root.data+sum(root.left)+sum(root.right);
        }
        public int countNodes(Node root){
            if(root==null){
                return 0;
            }
            return 1+countNodes(root.left)+countNodes(root.right);
        }

        public int diameter(Node root){ // O(N^2)
            if(root==null){
                return 0;
            }
            int ldiam=diameter(root.left);
            int lheight=height(root.left);
            int rdiam=diameter(root.right);
            int rheight=height(root.right);

            int self=lheight+rheight+1;

            return Math.max(Math.max(ldiam,rdiam),self);
        }
        static class Info{
            int diam;
            int height;
            public Info(int diam, int height){
                this.diam=diam;
                this.height=height;
            }
        }
        public Info diameter2(Node root){
            if(root==null){
                return new Info(0,0);
            }
            Info leftInfo=diameter2(root.left);
            Info rightInfo=diameter2(root.right);

            int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.height+rightInfo.height+1);
            int height=Math.max(leftInfo.height, rightInfo.height)+1;
            return new Info(diam, height);
        }
    }
    public static void main(String[] args){
        // int[] arr={1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree obj=new BinaryTree();
        // Node root=BinaryTree.Buildtree(arr);
        // System.out.println(root.data);
        // BinaryTree.preorder(root);
        // System.out.println();
        // BinaryTree.inorder(root);
        // System.out.println();
        // BinaryTree.postorder(root);
        // System.out.println();
        // System.out.println(obj.height(root));
        // obj.levelorder(root);
        // System.out.println(obj.sum(root));
        // System.out.println(obj.countNodes(root));


        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        System.out.println(obj.diameter(root));
        System.out.println(obj.diameter2(root).diam);

    }    
}
