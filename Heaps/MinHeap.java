import java.util.ArrayList;

public class MinHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            // add at last index
            arr.add(data);

            int x = arr.size()-1; // x is a child index
            int par = (x-1)/2;  //parent index

            while(arr.get(x) < arr.get(par)){  // O(log n)
                //swap 
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par , temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;
            if(left < arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx)>arr.get(right)){
                 minIdx = right;
            }
            if(minIdx != i){
                //swap 
                int temp = arr.get(i);
                arr.set(i , arr.get(minIdx));
                arr.set(minIdx , temp);

                heapify(minIdx);
            }
        }
      
        public int remove(){
            int data = arr.get(0);

            // step 1 - swap first and last 
            int temp = arr.get(0);
            arr.set(0 , arr.get(arr.size() -1));
            arr.set(arr.size() -1 , temp);

            // step 2 delete last index
            arr.remove(arr.size()-1);

            // step 3
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size()==0;
        }
//  so here we have made a priority Queue
    }
    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);
        pq.add(9);
        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
