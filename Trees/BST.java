public class BST {
    
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value){
            this.value = value;
            this.height = 0; 
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public BST() {
        // empty constructor
    }

    // Return height of node
    public int height(Node node){
        if(node == null){
            return -1; // convention: null node has height -1
        }
        return node.height;
    }

    // Check if BST is empty
    public boolean isEmpty(){
        return root == null;
    }

    // Public insert
    public void insert(int value){
        root = insert(root, value);
    }

    // Recursive insert helper
    private Node insert(Node node, int value){
        if(node == null){
            return new Node(value); // base case
        }

        if(value < node.value){
            node.left = insert(node.left, value);
        } else if(value > node.value){
            node.right = insert(node.right, value);
        } else {
            // Duplicate value, ignore or handle accordingly
            return node;
        }

        // Update height
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left)- height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }
}
