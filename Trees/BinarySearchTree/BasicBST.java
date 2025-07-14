// the inorder traversal in BST gives us the sorted sequence 
public class BasicBST{
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }        
    }

    // Build a BST
    public static Node insert( Node root,int val){
       if(root == null){
        root = new Node(val);
        return root;
       }
       if(root.data > val){
        // left subtree
        root.left = insert(root.left , val);
       }else{
        // right subtree
        root.right = insert(root.right , val);
       }
       return root;
    }

    // inorder traversal 
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }

    // Search in a binary search tree -> complexity O(h) -> O(log n) but O(n) in worst case when the tree is skewed
    public static boolean search(Node root , int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data> key){
            return search(root.left , key);
        }else{
            return search(root.right , key);
        }
    }

    // Delete a node -> firstly we need to search the node 
    // cases -> no child -> Delete Node & Return Null to parent
    // One child -> Delete Node & replace with child node 
    // Two child -> Replace the value with inorder successor and delete the node for inorder successor 
    // INorder successor in BSt -> Left most node in right subtree
    public static Node delete(Node root , int val){
        if(root.data < val){
            root.right = delete(root.right , val);
        }
        else if(root.data > val){
            root.left = delete(root.left , val);
        }
        else{
            // case 1-leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            //case2 -> single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            // case 3 - both children 
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right =  delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    // print in Range 
     

    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i=0 ; i<values.length ; i++){
            root = insert(root , values[i]);
        }
        // inorder(root);
        //System.out.println(search(root , 7));

        inorder(root);
        root = delete(root, 10);
        System.out.println();
        inorder(root);
        
    }
}