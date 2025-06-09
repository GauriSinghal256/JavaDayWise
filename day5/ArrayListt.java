import java.util.ArrayList;
import java.util.Collections;

public class ArrayListt {

    // swap 
    public static void swap(ArrayList<Integer> list , int idx1 , int idx2){

        int temp = list.get(idx1);
        list.set(idx1 , list.get(idx2));
        list.set(idx2 , temp);
    }
    public static void main(String[] args) {
        // initiation of Arraylist
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);

        // operations that can be performed on arraylists - Add O(1) , Get O(1) , Remove O(n) , Set Element at index O(n) , Contains Element O(n)
        // lets add some elements to the arraylist
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);

        // Now get element 
        // We need to tell which index element we want
        System.out.println(list.get(2));

        // Delete
        list.remove(2);
        System.out.println(list);

        // Set first add the index then the value that you want to add
        list.set(2,10);
        System.out.println(list);

        // To check whether list contains an element or not so we can write as 
        System.out.println(list.contains(1));   //true
        System.out.println(list.contains(9));   //false

        // If we want to add element by index
        list.add(1,9);
        System.out.println(list);

        // To print the sixe of array list
        System.out.println(list.size());

        // Loops in arraylist
        for(int i=0 ; i<list.size() ; i++){
           System.out.print(list.get(i) + " ");
        }

        // if we want to print reverse of the list
        for(int i=list.size()-1 ; i>=0 ; i--){
            System.out.print(list.get(i) + " ");
        }

        // To find the maximum element in arraylist 
        int max = Integer.MIN_VALUE;
        for(int i=0 ; i<list.size() ; i++){
            if(max<list.get(i)){
                max = list.get(i);
            }
        }
        System.out.println(max);

    //    swap in arraylist
    System.out.println(list);
     swap(list , 1 , 4);
     System.out.println(list);

    //  Sorting in arraylist 
    // ascending order 
    Collections.sort(list);
    System.out.println(list);

    // descending order 
    Collections.sort(list , Collections.reverseOrder());
    System.out.println(list);

    // MultiDimentional ArrayList
    




    }
}
