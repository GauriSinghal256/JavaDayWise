// facebook
// similar problems - disjoint sets , max meeting in a room
// you are given n activities with their start and end times.Select the maximum number of activities that can be performed by a single person
// assuming that a person canonly work on a single activity at a time.Activities are sorted acc to end time

// here we need to pick non overlapping activities
//TC-O(n)
import java.util.ArrayList;

public class ActivitySelection{
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        int maxAct =0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity is added
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i=1 ; i<end.length ; i++){
            if(start[i] >= lastEnd){
                // select the activity
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Maximum Activities = " + maxAct);
        for(int i=0 ; i<ans.size() ; i++){
            System.out.print("A"+ans.get(i) + " ");
        }
    }
}