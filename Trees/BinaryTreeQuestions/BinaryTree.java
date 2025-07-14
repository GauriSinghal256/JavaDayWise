import java.util.*;
class BinaryTree{

    public BinaryTree(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    // insert elements
    public void populate(Scanner scanner){
        System.out.println("Enter the root Node:");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner , root);
    }

    private void populate(Scanner scanner , Node node){
        System.out.println("Do you want to enter the left of" + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of" + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner , node.left);
        }

        System.out.println("Do you want to enter right of" + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of" + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner , node.right);
        }
    }
    // display function to display the tree elements
    public void display() {
            display(this.root , "");
        }
        private void display(Node node, String indent) {
            if (node == null) {
              return;
            }
            System.out.println(indent + node.value);
            display(node.left, indent + "\t");
            display(node.right, indent + "\t");
       }
    //    2nd display function to display the elements
    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
    if (node == null) {
        return;
    }

    prettyDisplay(node.right, level + 1); // right subtree first

    if (level != 0) {
        for (int i = 0; i < level - 1; i++) {
            System.out.print("|\t\t"); // visual connector lines
        }
        System.out.println("|------->" + node.value); // show node
    } else {
        System.out.println(node.value); // root node
    }

    prettyDisplay(node.left, level + 1); // then left subtree
}


       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.prettyDisplay();
       }

}