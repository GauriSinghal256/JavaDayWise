public class DoubleLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
        public static Node tail;
        public static int size;

        // add at first 
        public void addFirst(int data){
            Node newNode = new Node(data);
            size++ ;
            if(head == null){
                head = tail = newNode;
                return;
            } 
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        // add at last 
        public void addLast (int data){
            Node newNode = new Node(data);
            size++;
            if(head == null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        // print
        public void print(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data + "<->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // remove first 
        public int removeFirst(){
            if(head == null){
                System.out.println("Linked List is empty");
                return Integer.MIN_VALUE;
            }
            if(head.next == null){
                int var = head.data;
                head = tail = null;
                size--;
                return var;
            }
            int var = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return var;
        }


        // remove last
        public int removeLast(){
            if(head == null){
                System.out.println("Linked List is empty");
                return Integer.MIN_VALUE;
            }
            if(head.next == null){
                int var = head.data;
                head = tail = null;
                size--;
                return var;
            }
            int var = tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
            return var;
        }

        // reverse a doubly linked list 
        public void reverse(){
            Node curr = head;
            Node prev = null;
            Node next;
            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                curr.prev = next;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
        


        public static void main(String[] args) {
            DoubleLL ll = new DoubleLL();
            ll.addFirst(2);
            ll.addFirst(1);
            ll.addLast(3);
            ll.addLast(4);
            ll.removeFirst();
            ll.removeLast();
            ll.print();
        }


}
