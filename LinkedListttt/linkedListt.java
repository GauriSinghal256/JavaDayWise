

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
    // there are three steps to perform it - 
    //1.find the middle (slow-fast pointer)
    //2. reverse the second half (3 variables + 4 steps)
    //3. check if first half is equal to second half
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head == null || head.next==null){
            return true;
        }
        // step1 - find mid 
        Node middleNode = findMid(head);

        // step2 - reverse the 2nd half
        Node prev = null;
        Node curr = middleNode;
        Node next;
        while(curr!=null){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
        }
        Node right = prev; //right half head
        Node left = head;

        // step3 - check left half and right half 
        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }


    // Detect a loop in a linkedList - floyds cycle finding algorithm
    // we will use two pointer approach 
    //if at some point of time our fast and slow pointer points a same node then we can say that cycle is present 
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // Remove a cycle in a linked list 
    // here firstly we need to detect the loop/cycle 
    // then we have to make our slow pointer point to head i.e slow = head
    // then let them move by +1 as well move fast pointer by +1
    // then next time when fast and slow pointer will meet it will be our last node + 1
    //1. find the last node - lastnode is prev of fast
    // so here we also need to track one more variable which will point  to the previous of fast pointer
    //2. lastnode.next = null   i.e prev.next = null

    public static void removeCycle(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        // find meeting point
        slow = head;
        Node prev = null;
        while(slow != head){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle -> last.next = null
        prev.next = null;
    }

    // merge sort on a linked list 
    // 1. Find the middle of the linked list - slow-fast pointer
    // 2. Divide our linked list into two halves - it will be like 
    // mid.next = null  before this we need to store the next node of mid as the rightHead as now it is the separate linked list
    // 3 Now call merge sort for left half and merge sort right half so that they become sorted 
    // 4. Then we have to just merge them - make a dummy linked list which start with the dummy node with value -1
    // 5 Final linkedList will start as head.next of mergedLL
    
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1 , Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(head1!=null && head2!=null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;  
        }
        return mergeLL.next;
    }



    public Node mergeSort(Node head){

        if(head == null || head.next==null ){
            return head;
        }

        // find mid
        Node mid = getMid(head);
        // left and right ll

        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft , newRight);
    }


    // Zig-zag linked list ex-  1->2->3->4->5  so the answer must be 1->5->2->4->3
    // to solve this problem we will use 3 step approach 
    //1. find the middle node - first half ka last node 
    //2. Reverse the second half of linked list and divide the linked list into two parts
    //3. Alternate Merging  - (it is new so lets see how we are going to perform this step)
    // Node Lh = 1st half head     Node Rh = 2nd half head  
    // then we will taks 2 temporary variables Node nextL , Node nextR -> they will point to next node of the leftH and next node of the RightH
    // Now we have to perform the 4 steps in a while loop while(Lh!=null && Rh != null)
    // nextL = LH.next    LH.next = RH   nextR = RH.next    RH.next = nextL      now update   Rh = nextR  LH = nextL

    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
         Node curr = mid.next;
         mid.next = null;
         Node prev = null;
         Node next;
         while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         }

         Node left = head;
         Node right = prev;
         Node nextL , nextR;

        //alt merge 
        while(left !=null && right !=null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }


    



    
    public static void main(String args[]){
        linkedListt ll = new linkedListt();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // ll.head.next.next = new Node(3);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.add(2, 8);
        // ll.removeFirst();
        // ll.removeLast();
        // ll.addFirst(1);
        // ll.addLast(4);
        // ll.remove(2);
        // ll.print();
        // System.out.println(ll.search(4));
        // System.out.println(ll.recSearch(4));
        // ll.reverse();
        

        // Palindrom
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.print();
        // System.out.println(ll.checkPalindrome());

        // detect a cycle in linkedlist
        //     head = new Node(1);
        //     Node temp = new Node(2);
        //     head.next = temp;
        //     head.next.next = new Node(3);
        //     head.next.next.next = temp;
        //    // 1->2->3->2
        //    System.out.println(isCycle());
        //    removeCycle();
        //    System.out.println(isCycle());

        // merge Sort 
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(9);
        // ll.addFirst(4);
        // ll.addFirst(5);

        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        //zig - zag 
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.print();
        ll.zigZag();
        ll.print();





    }
}