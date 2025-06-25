
import java.util.PriorityQueue;

public class pqWithObjects{
    static class Student implements Comparable<Student>{ // function overriding 
        String name;
        int rank;

        public Student(String name , int rank){
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String args[]){
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A" , 4));
        pq.add(new Student("B" , 10));
        pq.add(new Student("C" , 2));
        pq.add(new Student("D" , 100));
        pq.add(new Student("G" , 1));
        

        // basically it will get printed in ascending order
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->" + pq.peek().rank); //O(1)
            pq.remove(); //O(log n)
        }

        // but if we want to reverse the order then we can write 
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    }
}