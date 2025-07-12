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

    // Check Subtree of another tree
    public static boolean isSubtree(Node root , Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isIdentical(root , subroot)){
                return true;
            }
        } 
        return isSubtree(root.left, subroot)|| isSubtree(root.right, subroot);
    }

    public static boolean isIdentical(Node root , Node subroot){
       if(root == null && subroot == null){
        return true;
       }else if(root == null || subroot==null || root.data!= subroot.data){
        return false;
       }
       if(!isIdentical(root.left, subroot.left)){
        return false;
       }
       if(!isIdentical(root.right, subroot.right)){
        return false;
       }

       return true;
    }

    // minimum distance between nodes 
    public static int lcaDist(Node root ,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDis = lcaDist(root.left, n);
        int rightDis = lcaDist(root.right, n);
        if(leftDis == -1 && rightDis == -1){
            return -1;
        }
        else if(leftDis == -1){
            return rightDis+1;
        }else{
            return leftDis+1;
        }
    }

    // kth ancestor of node 
    public static int KAncestor(Node root , int n , int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDis = KAncestor(root.left, n, k);
        int rightDis = KAncestor(root.right, n, k);
        if(leftDis== -1 && rightDis == -1){
            return -1;
        }
        int max = Math.max(leftDis , rightDis);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
   }

  // Transform the tree to sumTree 
   public static int Transform(Node root){
    if(root == null){
        return 0;
    }
    int leftChild = Transform(root.left);
    int rightChild = Transform(root.right);

    int data = root.data;
    int newLeft = root.left==null? 0:root.left.data;
    int newRight = root.right==null? 0:root.right.data;

    root.data = leftChild +newLeft +rightChild +newRight;
    return data;

   }    
    public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
    }

    // Check if the binary tree is univalued or not 
    public static boolean Univalued(Node root){
        if(root == null){
            return true;
        }
        if (root.left != null && root.left.data != root.data) {
        return false;
        }

        if (root.right != null && root.right.data != root.data) {
            return false;
        }

        return Univalued(root.left) && Univalued(root.right);
    }

    // Delete leaf nodes if valued as x 
    public static Node deleteLeafX(Node root, int x) {
    if (root == null) return null;

    root.left = deleteLeafX(root.left, x);
    root.right = deleteLeafX(root.right, x);

    if (root.left == null && root.right == null && root.data == x) {
        return null; 
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

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        //subroot.right = new Node(5);

        // System.out.println(height(root));
        // System.out.println(SumOfNodes(root));
        // System.out.println(SumOfNodes2(root));
        //System.out.println(diameter(root));
        //System.out.println(diameter2(root).diam);
        // Klevel(root, 1, 3);
        //System.out.println(lca(root, 4, 6).data);
        //System.out.println(lca2(root, 4, 6).data);
        // System.out.println(isSubtree(root, subroot));
        // int ld = lcaDist(root, 4);
        // int rd = lcaDist(root, 7);
        // System.out.println(ld+rd);

        // Transform(root);
        // preorder(root);

        Node Uni = new Node(2);
        Uni.left = new Node(2);
        Uni.right = new Node(2);
        Uni.left.left= new Node(2);
        Uni.left.right = new Node(5);
        Uni.right.left = new Node(2);
        System.out.println(Univalued(Uni));


        
    }
}
