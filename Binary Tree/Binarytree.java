import java.util.*;

import javax.swing.tree.TreeNode;
public class Binarytree {
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
    static class BinaryTree{         //Time complexity O(n);
        static int idx=-1;
        public static Node buildTree(int nodes[]){ //O(n)
            idx++;    
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }
        public static void preorder(Node root){// rule firstly print the left subtree of the node
                                                  // then print the right subtree
        // and then print the node
            if(root==null){
            //  System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            // Time complexity O(n)
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            // Time complexity O(n) 
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);        
            System.out.print(root.data+" ");

        }

        public int maxDepth(Node root) {
            if(root==null){
                return 0;
            }
            int left =maxDepth(root.left);
            int right=maxDepth(root.right);
            return 1+Math.max(left, right);
        
        }

        public static int  count(Node root){
            if(root==null){
                return 0;
            }
            int left=count(root.left);
            int right=count(root.right);       
            return left+right+1;

        }
        
        public static int  sum(Node root){
            if(root==null){
                return 0;
            }      
            return root.data+sum(root.left)+sum(root.right);

        }

        public static void levelOrder(Node root){
            if(root==null){
                return ;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }

            }
        }


    }
    public static void main(String[] args){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        //System.out.println(root.data);

        // tree.preorder(root);
        // System.out.println();
        // tree.inorder(root);
        // System.out.println();
        // tree.postorder(root);

        tree.levelOrder(root);
        System.out.println(tree.maxDepth(root));
        System.out.println(tree.count(root));
        System.out.println(tree.sum(root));
    }
}
