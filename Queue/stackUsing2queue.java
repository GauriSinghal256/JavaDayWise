import java.util.LinkedList;
import java.util.Queue;

public class stackUsing2queue {
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        // push
        public void push(int data){
           if(!q1.isEmpty()){
            q1.add(data);
           }else{
            q2.add(data);
           }
        }
    
    }
   
}
