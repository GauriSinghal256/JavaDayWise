import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
     //  We are given an infinite supply of denominations [1,2,5,10,20,50,100,500,2000].
    // Find min no. of coins/notes tomake change for a value V
    public static void main(String[] args) {
        Integer curr[] = {1,2,5,10,20,50,100,500,2000};
        Arrays.sort(curr , Comparator.reverseOrder());
        int amount = 590;
        int count =0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0 ; i<curr.length ;i++ ){
            if(curr[i] <= amount){
                while(curr[i] <= amount){
                    count ++;
                    ans.add(curr[i]);
                    amount -= curr[i];
                }
            }
        }
        System.out.println("total min coins that are required " + count );
        for(int i=0 ; i<ans.size() ; i++){
            System.out.println(ans.get(i));
        }
    }
}
