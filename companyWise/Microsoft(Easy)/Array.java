public class Array{
   //  https://leetcode.com/problems/sign-of-the-product-of-an-array/description/

//    the approach I have thought was ok but it was not optimized as I was doing the product which can become hactic for the larger sizes 
// here we just need to track the sign so the optimized solution can be 

 public static int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) sign *= -1;
        }
        return sign;
    }

    public static int arraySign2(int[] nums){
        int count = 0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] == 0){
                return 0;
            }
            else if(nums[i] <0){
                count++;
            }
        }
        if(count%2 == 0){
            return -1;
        }else{
            return 1;
        }
    }

    // https://leetcode.com/problems/palindrome-number/description/
    public boolean isPalindrom(int x){
        int original = x;
        int rev = 0;
        while(x!=0){
           int rem = x%10;
            rev = rev*10+rem;
            x = x/10;
        }
        if(rev == original){
            return true;
        }else{
            return false;
        }
    }


    // https://leetcode.com/problems/valid-palindrome/description/
    public static boolean isPalindrome(String s){
        int start =0;
        int end = s.length()-1;
        while(start<=end){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            else{
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                    return false;
                }else{
                    start++;
                    end --;
                }
            }
        }
        return true;
    }

    // https://leetcode.com/problems/defanging-an-ip-address/submissions/1696219746/
     public String defangIPaddr(String address) {
        String result = address.replace(".", "[.]");
        return result;
    }

    public static void main(String args[]){

        int arr[] = {-1,4,5,6,-5,9,-2};
        System.out.println(arraySign(arr));
    }
}