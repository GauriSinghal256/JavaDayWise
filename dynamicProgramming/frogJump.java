
import java.util.*;

public class frogJump {

    // recursion 
    public static int fJump(int idx, int cost[]) {
        if (idx == 0) {
            return 0;
        }
        int twoStep = Integer.MAX_VALUE;
        int oneStep = fJump(idx - 1, cost) + Math.abs(cost[idx] - cost[idx - 1]);
        if (idx > 1) {
            twoStep = fJump(idx - 2, cost) + Math.abs(cost[idx] - cost[idx - 2]);
        }
        return Math.min(oneStep, twoStep);
    }

    // memoization
    public static int fJump2(int idx, int cost[], int dp[]) {
        if (idx == 0) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int twoStep = Integer.MAX_VALUE;
        int oneStep = fJump2(idx - 1, cost, dp) + Math.abs(cost[idx] - cost[idx - 1]);
        if (idx > 1) {
            twoStep = fJump2(idx - 2, cost, dp) + Math.abs(cost[idx] - cost[idx - 2]);
        }
        return dp[idx] = Math.min(oneStep, twoStep);
    }

    // Tabulation 
   public static int fJump3(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n];
    dp[0] = 0;

    for (int i = 1; i < n; i++) {
        int oneStep = dp[i - 1] + Math.abs(cost[i] - cost[i - 1]);
        int twoStep = Integer.MAX_VALUE;
        if (i > 1) {
            twoStep = dp[i - 2] + Math.abs(cost[i] - cost[i - 2]);
        }
        dp[i] = Math.min(oneStep, twoStep);
    }

    return dp[n - 1];  // minimum cost to reach last stone
}
    public static int fjump4(int n, int[] cost, int[] dp) {
        dp[0] = 0;  // Base case: no cost on the first stone

        for (int i = 1; i < n; i++) {
            int oneStep = dp[i - 1] + Math.abs(cost[i] - cost[i - 1]);
            int twoStep = Integer.MAX_VALUE;

            if (i > 1) {
                twoStep = dp[i - 2] + Math.abs(cost[i] - cost[i - 2]);
            }

            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[n - 1];  // Minimum cost to reach last stone
    }

    // Space Optimised 
   public static int frogJumpOptimized(int n, int[] cost) {
        int prev1 = 0;   // cost to reach stone 0
        int prev2 = 0;   // cost to reach stone (i - 2)

        for (int i = 1; i < n; i++) {
            int oneStep = prev1 + Math.abs(cost[i] - cost[i - 1]);
            int twoStep = Integer.MAX_VALUE;

            if (i > 1) {
                twoStep = prev2 + Math.abs(cost[i] - cost[i - 2]);
            }

            int curr = Math.min(oneStep, twoStep);

            // Move the variables forward
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1; // prev1 holds the cost to reach last stone
    }


    public static void main(String[] args) {
        int cost[] = {30, 10, 60, 10, 60, 50};
        System.out.println(fJump(cost.length - 1, cost));
        int dp[] = new int[cost.length + 1];
        Arrays.fill(dp, -1);

        System.out.println(fJump2(cost.length - 1, cost, dp));
        System.out.println(fJump3(cost));

    }
}
