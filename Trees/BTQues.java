import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BTQues {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Find the height of the tree 
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }

    //Sum of nodes 
    // approach 1 - Recursive
    public static int SumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = SumOfNodes(root.left);
        int rightSum = SumOfNodes(root.right);
        int currSum = leftSum+rightSum+root.data;

        return currSum;
    }

    //approach 2 - Using traversal 
     public static int SumOfNodes2(Node root){
            Queue<Node> q = new LinkedList<>();
            int Sum = 0;
            q.add(root);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                Sum = Sum + currNode.data;
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
            }
            return Sum;
        }

        // Diameter of a tree -> Longest distance between two leaf nodes 
        // here basically we will consider 2 cases -> when the root node come to be the in the diameter -> when root node do not come in the diameter 
        // here in case1 -> if root node passes from the diameter -> diameter = lh+rh+1
        // here if in case 2 -> if root node do not pass from the diameter -> diameter = max(ldiam , rdiam)
        // so basically at every step I need to compare ldiam , rdiam , self= lh+rh+1
        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int leftDiam = diameter(root.left);
            int rightDiam = diameter(root.right);
            int lh = height(root.left);
            int rh = height(root.right);

            int selfDiam = lh+rh+1;
            return (Math.max(selfDiam , Math.max(leftDiam, rightDiam)));

        }

        // 2nd approach -> In the above one we were calling height function again and again for each node so the complexity is more 
        // so we can calculate the height in the same function only basically we will return a class that will have height as well as diameter associated with it 
        // so here we can reduce the complexity of the question
        static class Info {
        int ht;
        int diam;

        Info(int height, int diameter) {
            this.ht = height;
            this.diam = diameter;
        }
    }

    public static Info diameter2(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(leftInfo.ht + rightInfo.ht + 1, Math.max(leftInfo.diam, rightInfo.diam));
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(ht, diam);
    }

    // kth level of the tree 
    // here we will be given the value of the k then we need to print all the nodes that are basically at that kth level 
    public static void Klevel(Node root , int level , int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data + " ");
            return;
        }
        Klevel(root.left, level+1, k);
        Klevel(root.right, level+1, k);
    }

    // longest common ancestor -> The first node which is common to both the given nodes 
    // here the concept is like we need to find the path of the both nodes and then we need to traverse to them and find the commen ancestor 
    //  here we will try to store the path in the form of the array list 
    public static Node lca(Node root , int n1 , int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root , n1 , path1);
        getPath(root , n2 , path2);

        // longest common ancestor
        int i=0;
        for(; i< path1.size() && i< path2.size() ; i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        //last equal node -> i-1
        Node lca = path1.get(i-1);
        return lca;


    }

    public static boolean getPath(Node root , int node , ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == node){
            return true;
        }
        boolean foundLeft = getPath(root.left, node, path);
        boolean foundRight = getPath(root.right, node, path);

        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    // Longest common ancestor (approach->2)
    // here basically we are not using auxiliary data structures that is we are not using arraylists over here we are going to solve this problem using recursion 
    public static Node lca2(Node root , int n1 , int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = lca2(root.left , n1 , n2);
        Node rightLca = lca2(root.right , n1 , n2);

        if(rightLca == null){
            return leftLca;
        }
        if(leftLca == null){
            return rightLca;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(height(root));
        // System.out.println(SumOfNodes(root));
        // System.out.println(SumOfNodes2(root));
        //System.out.println(diameter(root));
        //System.out.println(diameter2(root).diam);
        // Klevel(root, 1, 3);
        //System.out.println(lca(root, 4, 6).data);
        System.out.println(lca2(root, 4, 6).data);



        
    }
}
