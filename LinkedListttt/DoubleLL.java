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

        // add
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
        


        public static void main(String[] args) {
            DoubleLL ll = new DoubleLL();
            ll.addFirst(2);
            ll.addFirst(1);
            ll.print();
        }


}
