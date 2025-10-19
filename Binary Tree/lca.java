import java.util.ArrayList;
import java.util.List;

public class lca {
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
    public static class BinaryTree{
        public void ancestors(Node root, int val1, int val2, List<Integer> list, List<List<Integer>> result){
            if(root == null){
                return;
            }
            if(root.data == val1){
                list.add(root.data);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            if(root.data == val2){
                list.add(root.data);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            list.add(root.data);
            ancestors(root.left, val1, val2, list, result);
            ancestors(root.right , val1, val2, list, result);
            list.remove(list.size() - 1);
        }
        public boolean newancestors(Node root, int val, ArrayList<Node> path){
            if(root == null) return false;
            path.add(root);

            if(root.data == val){
                return true;
            }

            boolean left = newancestors(root.left, val, path);
            boolean right = newancestors(root.right, val, path);
            if(left || right){
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }
        public Node lca2(Node root, int n1, int n2){
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }
            Node leftlca = lca2(root.left, n1, n2);
            Node rightlca = lca2(root.right, n1, n2);

            if(rightlca == null){
                return leftlca;
            }
            if(leftlca == null){
                return rightlca;
            }
            return root;
        }

    }  
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        /*
                1
               / \
              2   3
             / \ / \
            4  5 6  7
     */


        Node root1 = new Node(1);
        root1.left=new Node(2);
        root1.right=new Node(3);
        root1.left.left=new Node(4);
        root1.left.right=new Node(5);
        root1.right.left=new Node(6);
        root1.right.right=new Node(7);

         //ancestor
        // List<List<Integer>> result = new ArrayList<>();
        // tree.ancestors(root1, 4, 7, new ArrayList<>(), result);
        // for(List<Integer> list : result){
        //     System.out.print(list + " ");
        // }
        // System.out.println(tree.isSubtree(root1,subRoot));
        // System.out.println();

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        tree.newancestors(root1, 4, path1);
        tree.newancestors(root1, 7, path2);
        for(Node list : path1){
            System.out.print(list.data + " ");
        }
        for(Node list1 : path2){
            System.out.print(list1.data + " ");
        }


        
         /* root 1
                1
               / \
              2   3
             / \ / \
            4  5 6  7
     */
        System.out.println();
        Node ans = tree.lca2(root1, 4, 5);
        System.out.println(ans.data);
    }

}
