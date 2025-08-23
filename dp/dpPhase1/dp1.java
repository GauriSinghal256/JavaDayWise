

public class dp1{

    // fibonacchi Series by the help of dp -> here instead of computing one problem again and again we are just storing it in the array so that instead of computing it again we will use the stored value
    // memoization -> basically advanced recursion 
    public static int fibo(int n , int f[]){
        if(n<=1){
            return n;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n] = fibo(n-1, f)+ fibo(n-2 , f);
        return f[n];
    }

    // tabulation 
    public static int fiboTab(int n){
        int dp[] = new int [n+1];
        dp[1] = 1;
        for(int i=2 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // Climbing Stairs -> via recursion 
    public static int countWays(int n){
        if(n==0) return 1;
        if(n<0) return 0;
        return countWays(n-1)+ countWays(n-2);
    }

    // Memoization
    public static int countWays(int n , int ways[]){
        if(n==0) return 1;
        if(n<0) return 0;
        if(ways[n] != -1){
            return ways[n];
        }
        ways[n] = countWays(n-1 , ways) + countWays(n-2 , ways);
        return ways[n];
    }

    // Tabulation 
    public static int countWaysTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1 ; i<=n ; i++){
            if(i==1){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }

    // https://leetcode.com/problems/min-cost-climbing-stairs/description/

    // Recursive Approach 
    public static int minCostRec(int[] cost, int i) {
        if (i >= cost.length) return 0;  
        return cost[i] + Math.min(minCostRec(cost, i + 1), minCostRec(cost, i + 2));
    }

    // Memoization 
    public static int minCostMemo(int[] cost, int i, int[] dp) {
    if (i >= cost.length) return 0;
    if (dp[i] != -1) return dp[i];  

    dp[i] = cost[i] + Math.min(minCostMemo(cost, i+1, dp), minCostMemo(cost, i+2, dp));
    return dp[i];
}

    // Tabulation 
    public static int minCostTab(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n+1];

    dp[n] = 0; // top floor
    dp[n-1] = cost[n-1]; // last step

    for (int i = n-2; i >= 0; i--) {
        dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
    }

    return Math.min(dp[0], dp[1]);
}

public static int minCostOptimized(int[] cost) {
    int n = cost.length;
    int next1 = 0, next2 = 0;

    for (int i = n-1; i >= 0; i--) {
        int curr = cost[i] + Math.min(next1, next2);
        next2 = next1;
        next1 = curr;
    }
    return Math.min(next1, next2);
}

// 0-1 Knapsack using recursion 
    public static int Knapsack(int val[] , int wt[] , int W , int n){
        if(W==0 || n==0){
            return 0;
        }
        if(wt[n-1]<=W){  //valid
            // include
            int ans1 =  val[n-1]+ Knapsack(val , wt , W-wt[n-1] , n-1);
            // exclude 
            int ans2 = Knapsack(val , wt , W , n-1);
            return Math.max(ans1 , ans2);
        } else{
            return Knapsack(val , wt , W , n-1);
        }
    }


    // 0-1 Knapsack Memoization 
    public static int KnapsackMemo(int val[] , int wt[] , int W , int n , int dp[][]){
        if(W==0 || n==0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){  //valid
            // include
            int ans1 =  val[n-1]+ KnapsackMemo(val , wt , W-wt[n-1] , n-1 , dp);
            // exclude 
            int ans2 = KnapsackMemo(val , wt , W , n-1,dp);
            dp[n][W] = Math.max(ans1 , ans2);
            return dp[n][W];
        } else{
            dp[n][W] =  KnapsackMemo(val , wt , W , n-1 , dp);
            return dp[n][W];
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int f[] = new int[n+1];
        // System.out.println(fibo(n , f));
        // System.out.println(fiboTab(7));
        // System.out.println(countWays(6));
        // int ways[] = new int[n+1];
        // Arrays.fill(ways , -1);
        // System.out.println(countWays(5,ways));
        // System.out.println(countWaysTab(7));
        //  int[] cost = {10, 15, 20};
        //  System.out.println(Math.min(minCostRec(cost, 0), minCostRec(cost, 1)));

        // int m = cost.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // System.out.println(Math.min(minCostMemo(cost, 0 ,dp), minCostMemo(cost, 1 , dp)));

        // System.out.println(minCostTab(cost)); 


        // Knapsack

        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        // System.out.println(Knapsack(val, wt, W, val.length));
         int dp[][] = new int[val.length+1][W+1];
         for(int i=0 ; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){
                dp[i][j] = -1;
            }
         }

         System.out.println(KnapsackMemo(val, wt, W, val.length , dp));


    }
}