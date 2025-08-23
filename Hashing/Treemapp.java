// here keys are sorted so tc is increased
// insert , remove get ->TC -> O(log n)
// implemented by using red black trees 

import java.util.*;
public class Treemapp {
    public static void main(String[] args) {
       TreeMap<String , Integer> tm = new TreeMap<>();
       tm.put("India" , 100);
       tm.put("China" , 150);
       tm.put("US" , 50);
       tm.put("Indonesia" , 10);
       System.out.println(tm);
    }
}
