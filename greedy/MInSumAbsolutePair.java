
import java.util.Arrays;

public class MInSumAbsolutePair {
    
    // given two arrays A and B of equal length n . Pair each element of Array A to an element in array B, such that 
    // sum S of absolute difference of all the pairs is minimum
    // absolute of 1 is 1 and -1 is 1 
    public static void main(String[] args) {
        int A[] = {1,2,3};
        int B[] = {2,1,3};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for(int i=0 ; i<A.length ; i++){
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println(minDiff);
    }
}
