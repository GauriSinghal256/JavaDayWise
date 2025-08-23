// hashmap , hashsets 
// map -> hashmap , Linked Hashmap , TreeMap
// set -> hashset , Linked Hashset , Treeset
// hashmap -> (key , value)  here key is unique
// insert , remove , search -TC O(1)
// operations on hashmap -> 
// put(key , value) ,  get(key) , containsKey(key) , remove(key)
// hashmaps are unorderd maps 

import java.util.*;

public class hashing {
    public static void main(String[] args) {
        // create 
        HashMap<String , Integer> hm = new HashMap<>();

        // insert 
        hm.put("India" , 100);
        hm.put("China" , 150);
        hm.put("US" , 50);
        hm.put("Indonesia" , 10);
        hm.put("Nepal" , 5);
        hm.put("Bhutan" , 10);

        System.out.println(hm);

        // Get 
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.get("Indonesia"));

        // containsKey
        System.out.println(hm.containsKey("India")); 
        System.out.println(hm.containsKey("Indonesia")); 

        // remove
        System.out.println( hm.remove("China"));
        System.out.println(hm);
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());
    
        // iteration on hashmap 
        
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("key=" + k + ", value=" + hm.get(k));
        }




    }
}
