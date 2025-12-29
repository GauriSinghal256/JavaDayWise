public class explore {
    // product of array except self
    public static int[] productExceptSelf(int[] nums) {
        int mult = 1;
        int result[] = new int[nums.length];
        for(int i=0;i<=nums.length-1 ; i++){
            int j = 0;
            while(j<nums.length){
                if(j==i){
                    j++;
                    continue;
                }
                mult = mult * nums[j];
                j++;
            }
            result[i] = mult;
            mult = 1;
        }
        return result;
    }
    // time complexity is O(n^2) and space complexity is O(n)

    // 2nd approach -> Using prefix and suffix product by excluding the current index
    // time complexity is O(n) and space complexity is O(n)
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        
        for (int i = 0; i < n; i++) {
            prefix[i] = prefix[i] * suffix[i];
        }
        
        return prefix;
    }

    // the most optimized approach -> using only one array to store the result
    // time complexity is O(n) and space complexity is O(1)
    public static int[] productExceptSelf3(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n];

    prefix[0] = 1;
    for (int i = 1; i < n; i++) {
        prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    int suffix = 1;
    for (int i = n - 1; i >= 0; i--) {
        prefix[i] = prefix[i] * suffix;
        suffix *= nums[i];
    }

    return prefix;
}





    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        // int result[] = productExceptSelf(nums);
        int result[] = productExceptSelf2(nums);

        for(int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }
}
