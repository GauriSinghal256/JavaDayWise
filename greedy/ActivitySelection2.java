// It is same as ActivitySelction but only one condition is diferent that we are not given end time in soretd manner 
// Tc - O(nlogn)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection2 {
    public static void main(String[] args) {
        int start[] = {0,1,3,5,5,8};
        int end[] = {6,2,4,7,9,9};

        // sorting
        // we need to make a 2D array which will have three cols first contain the index second contain start and third contain end
        int activities[][] = new int[start.length][3];
        for(int i=0 ; i<start.length ; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // lambda function -> shortform 
        // as we need to sort it on the basis of end time and it is col 2 
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));


        int maxAct =0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity is added
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1 ; i<end.length ; i++){
            if(activities[i][1] >= lastEnd){
                // select the activity
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum Activities = " + maxAct);
        for(int i=0 ; i<ans.size() ; i++){
            System.out.print("A"+ans.get(i) + " ");
        }
    }
}
