import java.util.HashMap;

public class UniqueSum {
     public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0 ; i<nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }
         for (Integer num : map.keySet()) {
            if (map.get(num) == 1) {
                sum += num;
            }
        }
        return sum;
    }

    // more optimised
    public int sumOfUnique2(int[] nums) {
        int[] freq = new int[101];  // assuming 1 <= nums[i] <= 100
        int sum = 0;

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i <= 100; i++) {
            if (freq[i] == 1) sum += i;
        }

        return sum;
    }
    public static void main(String[] args) {
        
    }
}
