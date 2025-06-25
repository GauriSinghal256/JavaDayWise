
import java.util.PriorityQueue;

public class priorityQueue{
    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);
        pq.add(4);
        pq.add(7);
        pq.add(1);
        pq.add(2);

        // basically it will get printed in ascending order
        while(!pq.isEmpty()){
            System.out.println(pq.peek()); //O(1)
            pq.remove(); //O(log n)
        }

        // but if we want to reverse the order then we can write 
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    }
}