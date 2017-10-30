import java.util.PriorityQueue;

/**
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number, and n does not exceed 1690.

 */
public class Ugly_Number_II {
    public int nthUglyNumber(int n) {
        if(n <= 0){ return 0; }
        int nth = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        long res = 1;
        long pre = 0;
        /* priorityQueue pop value from small to largest, already sorted */
        while(nth < n){
            while(res == pre || res < 0){ res = pq.poll(); } /* skip duplicate values, some value might even overflow to negative, just skip them */
            /* for each popped value, which is the smallest among the pq, increase it by 2,3,5, and check for the next smallest */
            pq.offer(2 * res);
            pq.offer(3 * res);
            pq.offer(5 * res);
            nth++;
            pre = res;
        }
        return (int)res;
    }
    public static void main(String[] args){
        System.out.print(new Ugly_Number_II().nthUglyNumber(1600));
    }
}
