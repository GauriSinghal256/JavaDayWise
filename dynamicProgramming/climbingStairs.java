import java.util.Arrays;

public class climbingStairs {

    // recursion 
    public static int climbStairs(int n){
        if(n<=1){
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    // memoization
     public static int climbStairs2(int n , int f[]){
        if(n == 1 || n==0){
            return n;
        }
        if(f[n]!=-1){
            return f[n];
        }
        f[n] =  climbStairs2(n-1, f) + climbStairs2(n-2, f);
        return f[n];
    }

    // Tabulation 
    public static int climbStairs3(int n, int dp[]){
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // space optimised 
    public static int climbingStairs4(int n){
        int prev1 = 1;
        int prev2 = 0;
        int curr;
        for(int i=2 ; i<=n ; i++){
            curr = prev1+prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }



    public static void main(String[] args) {
        System.out.println(climbStairs(7));
        int n= 7;
        int f[] = new int[n+1];
        Arrays.fill(f , -1);
        
    }
}
