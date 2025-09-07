import java.util.*;
public class practice {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
    public static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int[] arr){
            index++;
            if(arr[index] == -1){
                return null;
            }
            Node newNode = new Node(arr[index]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }
        public static void preorder(Node root){
            if(root == null) return;

            System.out.print(root.data+"->");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            if(root == null) return;
            
            inorder(root.left);
            System.out.print(root.data+"->");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root == null) return;
            
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+"->");
        }
        public static void levelorder(Node root){
            if(root == null) return;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){                
                    Node current = queue.poll();
                    if(current.left != null) queue.offer(current.left);
                    if(current.right != null) queue.offer(current.right);
                    System.out.print(current.data+" ");
                }
                System.out.println();
            }            
        }
        public static int maxDepth(Node root){
            if(root == null){
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1 + Math.max(left, right);
        }
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);
            return 1 + Math.max(left, right);
        }
        public static int count(Node root){
            if(root == null){
                return 0;
            }
            int left = count(root.left);
            int right = count(root.right);
            return 1 + left + right;
        }
        public static int sum(Node root){
            if(root == null){
                return 0;
            }
            int left = sum(root.left);
            int right = sum(root.right);
            return root.data + left + right;
        }
        public static class Info{
            int diam;
            int ht;
            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }
        public static Info diameter(Node root){
            if(root == null){
                return new Info(0, 0); 
            } 
            Info lInfo = diameter(root.left);
            Info rInfo = diameter(root.right);
            int finalDiam = Math.max(Math.max(lInfo.diam, rInfo.diam), lInfo.ht + rInfo.ht + 1);         
            int height = Math.max(lInfo.ht, rInfo.ht) + 1;

            return new Info(finalDiam, height);
        }
        public boolean isSameTree(Node root, Node subRoot){
            if(root == null && subRoot == null) return true;
            if(root == null || subRoot == null || root.data != subRoot.data) return false;
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        }
        public boolean isSubtree(Node root, Node subRoot){
            if(subRoot == null) return true;
            if(root == null) return false;
            if(root.data == subRoot.data){
                if(isSameTree(root, subRoot)){
                    return true;
                }
            } 
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        // public void topViewwrong(Node root, HashSet<Integer> set, int index){
        //     if(set.contains(index)) return;
        //     if(root == null) return;
            
        //     set.add(index);
        //     topView(root.left, set, index - 1);
        //     System.out.println(root.data);
        //     topView(root.right, set, index + 1);
   
        // }
        static class InfoTop{
            Node node;
            int hd;

            public InfoTop(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        public void topViewCorrect(Node root){
            if(root == null){
                return;
            }
            Queue<InfoTop> queue = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;
            
            queue.offer(new InfoTop(root, 0));
            queue.offer(null);

            while(!queue.isEmpty()){
                InfoTop curr = queue.poll();

                if(curr == null){
                    if(queue.isEmpty()){
                        break;
                    }else{
                        queue.add(null);
                    }
                }else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd, curr.node);
                    }
                    if(curr.node.left != null){
                        queue.offer(new InfoTop(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if(curr.node.right != null){
                        queue.offer(new InfoTop(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }
            for(int i = min; i <= max; i++){
                System.out.print(map.get(i).data+" ");
            }
        }
        public void kthlevel(Node root, int k, int level){
            if(root == null){
                return;
            }
            if(level == k){
                System.out.print(root.data+" ");
                return;
            }
            kthlevel(root.left, k, level + 1);
            kthlevel(root.right, k, level + 1);
        }
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
        public void subset(List<String> result, String str, String ab, int index){
            if(index == ab.length()){
                result.add(str);
                return;
            }
            subset(result, str, ab, index + 1);
            subset(result, str + ab.charAt(index), ab, index + 1);
            subset(result, str + (int)ab.charAt(index), ab, index + 1);
            
        }

    }

    public static void main(String[] args){
        int nodes[]={1, 2, 4, 3, -1, -1, -1, 5, 9, -1, -1, -1, -1};
        // int nodes[]={1, 2, 4, 3, -1, -1, -1, 5, 9, -1, -1, -1, -1};
        /*
                1
               / 
              2   
             /  \ 
            4    5 
           /    /
          3    9 
     */
        
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        tree.preorder(root);
        System.out.println("null");
        tree.inorder(root);
        System.out.println("null");
        tree.levelorder(root);
        System.out.println("Depth or height - " + tree.maxDepth(root));
        System.out.println("Count - " + tree.count(root));
        System.out.println("Sum - " + tree.sum(root));
        System.out.println("Diameter - " + tree.diameter(root).diam);
        

        /*
                1
               / \
              2   3
             / \ / \
            4  5 6  7
     */


        Node root1=new Node(1);
        root1.left=new Node(2);
        root1.right=new Node(3);
        root1.left.left=new Node(4);
        root1.left.right=new Node(5);
        root1.right.left=new Node(6);
        root1.right.right=new Node(7);

        /*  
                2
               / \
              4   5

        */  

        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);

        HashSet<Integer>  set = new HashSet<>();
        // tree.topViewwrong(root, set, 0);
        tree.topViewCorrect(root1);
        System.out.println();
        int level = 3;
        tree.kthlevel(root1, level, 1);
        System.out.println();




         /* root 1
                1
               / \
              2   3
             / \ / \
            4  5 6  7
     */

        //ancestor
        // List<List<Integer>> result = new ArrayList<>();
        // tree.ancestors(root1, 4, 7, new ArrayList<>(), result);
        // for(List<Integer> list : result){
        //     System.out.print(list + " ");
        // }
        // System.out.println(tree.isSubtree(root1,subRoot));
        // System.out.println();
        // ArrayList<Node> path1 = new ArrayList<>();
        // ArrayList<Node> path2 = new ArrayList<>();
        // tree.newancestors(root1, 4, path1);
        // tree.newancestors(root1, 7, path2);
        // for(Node list : path1){
        //     System.out.print(list.data + " ");
        // }
        // for(Node list1 : path2){
        //     System.out.print(list1.data + " ");
        // }


        //subset code
        // System.out.println();
        // System.out.print("subsets  : ");
        // String strr = "ab";
        // List<String> result2 = new ArrayList<>();
        // tree.subset(result2, "", strr, 0);
        // System.out.println(result2);



        
         /* root 1
                1
               / \
              2   3
             / \ / \
            4  5 6  7
     */
        Node ans = tree.lca2(root1, 4, 5);
        System.out.println(ans.data);
    }
}
