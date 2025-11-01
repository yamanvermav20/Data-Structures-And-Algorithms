import javax.swing.tree.TreeNode;

public class Buildtree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int preIndex = 0;
    public static Node build(int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;
        int value = preorder[preIndex++];
        int index = find(inorder, value, start, end);
        Node root = new Node(value);
        root.left = build(preorder, inorder, start, index - 1);
        root.right = build(preorder, inorder, index + 1, end);
        return root;
    }
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " "); 
        preorder(root.left);              
        preorder(root.right);             
    }
    public static int find(int[] inorder, int value, int start, int end){
        for(int i = start ; i <= end; i++){
            if(inorder[i] == value) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int preorder[] = {1, 2, 4, 5, 3, 6};
        int inorder[] = {4, 2, 5, 1, 3, 6};
        Node root = build(preorder, inorder, 0, preorder.length - 1);
        preorder(root);
    }
}
