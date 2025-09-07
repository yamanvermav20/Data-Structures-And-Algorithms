public class practice {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root, int value){
        if(root == null){
            Node newNode = new Node(value);
            return newNode;
        }
        if(root.data > value){
            root.left = insert(root.left, value);
        }
        if(root.data < value){
            root.right = insert(root.right, value);
        }
        return root;
        
    }
    public static void inorder(Node root){
        if(root == null) return;
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){
        if(root == null) return false;
        if(root.data == key) return true;
        if(key < root.data){
            if(search(root.left, key)) return true;
            // return search(root.left, key); we can also do like this
        }
        if(key > root.data){
            if(search(root.right, key)) return true;
            // return search(root.right, key) can also do like this
        }
        return false;
    }
    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else{
            // case 1 = leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            
            //case 2 = single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case3 = both children
            Node IS = InorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node InorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args){
        int[] arr = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int i = 0; i < arr.length; i++){
            root = insert(root, arr[i]);
        }
        inorder(root);
        System.out.println();
        int key = 1;
        System.out.println(search(root, key));
        delete(root, 3);
        inorder(root);
    }
}
