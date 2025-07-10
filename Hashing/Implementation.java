import java.util.*;
public class Implementation{
    static class HashMap<K,V>{  //generic in java that means we dont know what datatype is going to come in it
       private class Node{
        K key;
        V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
       }
       private int size;    //n
       private LinkedList<Node> buckets[];  //N = buckets.length

       @SuppressWarnings("unchecked")
       public HashMap() {
        this.size = 4;
        this.buckets = new LinkedList[4];
        for(int i=0 ; i<4 ; i++){
            this.buckets[i] = new LinkedList<>();
        }
       }


       private int hashFunction(K key){
           int hc = key.hashCode();
           return Math.abs(hc) % size;
       }

       private int SearchInLL(K key , int bi){
        Linkedlist<Node> ll = buckets[bi];
        int di = 0;
        for(int i=0 ; i<ll.size() ; i++){
            Node node = ll.get(i);
            if(node.key == key){
                return di ;
            }
        }
       }

       public void put(K key , V value){
        int bi = hashFunction(key); // 0 to 3 (basically the size of array)
        int di = SearchInLL(key , bi);  // valid index , -1

       }

       
    }

    public static void main(String[] args) {
        
    }
}