

public class linkedListt{

    // Node class
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        } 
    }
    public static Node head;
    public static Node tail;
    public static int size;



    // function to add in the linkedlist at first position
    // Here time complexity is O(1)
    public void addFirst(int data){

        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add last in a linkedlist 
    // time complexity is O(1)
    public void addLast(int data){

        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // print a linkedlist
    public void print(){
        if(head == null){
            System.out.println("Linked List is empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    // Add in the middle of the linkedlistt
    public void add(int idx , int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // remove in a linkedlist - remove first 
    public int removeFirst(){
        if(size == 0){
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size =0;
            return val;
        }
        int val = head.data;
        size--;
        head = head.next;
        return val;
    }

    // remove in a linkedlist - remove last
    public int removeLast(){
        if(size == 0){
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size =0;
            return val;
        }
        Node prev = head;
        for(int i=0 ; i<size-2 ; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // remove in a linkedlist - middle
    public int remove(int idx){
        if(idx == 0){
            removeFirst();
        }else if(idx == size){
            removeLast();
        }
        Node prev = head;
        for(int i=0 ; i<idx-1 ; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }


    // Search in a linked list iterative 
    public int search(int key){
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // search recursive in a linked list 
    public int helper(Node head , int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next , key);
        if(idx == -1){
            return -1;
        }
        return idx+1;

    }
    public  int recSearch(int key){
        return helper(head , key);
    }

    // reverse a linked list 
    // just to remember it - there are 3 variables and 4 steps
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find and remove the nth node from end
    public void deleteNthfromEnd(int n){
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(n==sz){
            head = head.next;
            return;
        }
        //  sz-n as we are starting index from 1
        int i=1; 
        int iToFind = sz - n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // check if a linkedlist is a palindrom 
    



    
    public static void main(String args[]){
        linkedListt ll = new linkedListt();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // ll.head.next.next = new Node(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(2, 8);
        ll.removeFirst();
        ll.removeLast();
        ll.addFirst(1);
        ll.addLast(4);
        ll.remove(2);
        ll.print();
        // System.out.println(ll.search(4));
        // System.out.println(ll.recSearch(4));
        ll.reverse();
        ll.print();



    }
}