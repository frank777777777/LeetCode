/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.

 */
public class SqrtX {
//    public int mySqrt(int x){
//        return mySqrtHelper(x,0,x);
//    }
//    private int mySqrtHelper(int x, int low, int high){
//        if(low == high)
//            return low;
//        /* rounding up */
//        int mid = (high - low) % 2 == 1 ? low + (high - low) / 2 + 1 : low + (high - low) / 2;
//        /* avoid overflow */
//        if(mid == x/mid){
//            return mid;
//        }else if(mid > x/mid){
//            return mySqrtHelper(x, low, mid-1);
//        }else{
//            return mySqrtHelper(x,mid,high);
//        }
//    }

    /* no need to round up. base case, check the high and low, and return the low*/
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 0;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                start = mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end > x / end) {
            return start;
        } else {
            return end;
        }
    }
    public static void main(String[] args){
        System.out.println(new SqrtX().mySqrt(17));
    }
}
