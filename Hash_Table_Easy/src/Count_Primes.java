import java.util.HashSet;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Count_Primes {
    public int countPrimes(int n) {
        if(n<3)
            return 0;
        int[] map = new int[n];
        int count=1;
        map[1]=1;
        int sqrt=(int)Math.sqrt(n);
        /* manually produce a non-prime number, and put it in the set, count the set, and compute the
        * count of the prime number by n-1-count, since it is less than n, exclude n itself */
        for(int i=2;i<=sqrt;i+=1){
            if(map[i]==1)
                continue;
            for(int j=2;j*i<n;j++){
                if(map[i*j]==0){
                    map[i*j]=1;
                    count++;
                }
            }
        }
        return n-1-count;
    }
    public static void main(String[] args){
        int n=12;
        System.out.print(new Count_Primes().countPrimes(n));
    }
}
