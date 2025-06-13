public class CircularLL {
    public class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node last;

    public CircularLL() {
        this.last = null;
    }

    // Insert at beginning
    public void insertBeg(int data) {
        Node newNode = new Node(data);

        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
    }

    // Insert at end
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode; 
        }
    }

    // Insert after a given node
    public void insertAfter(int target, int data) {
        if (last == null) {
            return;
        }
        Node curr = last.next;
        do {
            if (curr.data == target) {
                Node newNode = new Node(data);
                newNode.next = curr.next;
                curr.next = newNode;
                if (curr == last) {
                    last = newNode;
                }
                return;
            }
            curr = curr.next;
        } while (curr != last.next);
    }

    // Delete from beginning
    public void deleteFromBeg() {
        if (last == null) {
            System.out.println("LL is empty");
            return;
        }
        if (last.next == last) {
            last = null;
        } else {
            last.next = last.next.next;
        }
    }

    // Delete from end
    public void deleteFromEnd() {
        if (last == null) {
            System.out.println("LL is empty");
            return;
        }
        if (last.next == last) {
            last = null;
        } else {
            Node curr = last.next;
            while (curr.next != last) {
                curr = curr.next;
            }
            curr.next = last.next;
            last = curr;
        }
    }

    //delete a node after a given node 
    public void deleteAfter(int target){
        if(last == null){
            return;
        }
        Node curr = last.next;
        do { 
            if(curr.data == target && curr.next != last.next){
                curr.next = curr.next.next;
                if(curr.next == last.next){
                    last = curr;
                }
                return;
            }
            curr = curr.next;
        } while (curr!=last.next);
    }

    // Display the list
    public void display() {
        if (last == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = last.next;
        do {
            System.out.print(curr.data + " -> ");
            curr = curr.next; 
        } while (curr != last.next);
        System.out.println("(back to start)");
    }

    public static void main(String[] args) {
        CircularLL ll = new CircularLL();
        ll.insertBeg(1);
        ll.insertBeg(3);
        ll.insertBeg(4);
        ll.insertBeg(5);
        ll.insertLast(2);

        ll.display();

        ll.deleteFromBeg();
        ll.display();

        ll.deleteFromEnd();
        ll.display();

        ll.insertAfter(1, 99);
        ll.display();
    }
}

