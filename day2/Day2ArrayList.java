package day2;
import java.util.*;

public class Day2ArrayList {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(67);
        list.add(68);
        list.add(679);
        list.add(7);
        list.add(51);
        list.set(0,99);
        list.remove(2);

        for(int i=0 ; i<4 ; i++){
            System.out.println(list.get(i));
        }


        System.out.println(list);

        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        for(int i=0 ; i<3 ; i++){
            list2.add(new ArrayList<>());
        }

        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3; j++){
                list2.get(i).add(sc.nextInt());
            }
        }

        System.out.println(list2);
        

    }
}
