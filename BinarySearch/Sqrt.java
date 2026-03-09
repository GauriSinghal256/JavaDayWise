public class Sqrt{
    public static  int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int low = 1, high = x, ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(mid <= x / mid){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }
}