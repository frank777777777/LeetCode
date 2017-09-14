/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */
public class Sqrt_x {
    public int mySqrt(int x) {
        int res= calculation(0,x,x);
        if(x%res>0)
            return res-1;
        return res;
    }
    private int calculation(int start, int end, int x){
        if(start>=end)
            return start;
        int mid = start+(end-start)/2;
        if(mid>x/mid){
            return calculation(start,mid-1,x);
        }else{
            return calculation(mid+1,end,x);
        }
    }
    public static void main(String[] args){
        int x = 2147395600;
        System.out.print(new Sqrt_x().mySqrt(x));
    }
}
