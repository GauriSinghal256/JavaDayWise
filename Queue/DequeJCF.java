import java.util.*;

public class DequeJCF {
    // Deque is a double ended queue which has its special methods in this we can access both the first and last element of the queue 
    // the methods are - addFirst() , addLast() , removeFirst() , removeLast() , getFirst() , getLast()
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);

        System.out.println(deque);
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
    }
}
