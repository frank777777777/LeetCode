/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.*/
public class Counting_Bits {
    /* the pattern is 0 | 1 | 1 2 | 1 2 2 3 | 1 2 2 3 2 3 3 4 | 1 2 2 3 2 3 3 4 2 ..... */
    /* the next partition, is repeating the previous partition, and then +1 for every value in the previous partition
     * So I use three cursors here, before, current, and after. The offset always doubles, and the movement of current
      * cursor also doubles in size */
    public int[] countBits(int num) {
        /* handles edge cases, when num is 0 or 1 */
        int[] res = new int[num + 1];
        res[0] = 0;
        if(num == 0)
            return res;
        res[1] = 1;
        if(num == 1){
            return res;
        }
        /* if num is neither 0 nor 1, then it is at lease 2 */
        int before, current = 2, after;
        /* offset is the amount current cursor offset to before and after, count is how many steps current cursor should move */
        int offset = 1, count = 1;
        while(current <= num){
            /* offset to before and after */
            before = current - offset;
            after = current + offset;
            /* copy the previous partition, and after cursor +1 for previous partition */
            res[current] = res[before];
            if(after <= num){
                res[after] = res[before] + 1;
            }
            current++;
            count--;
            /* if the current cursor finishes his movement, offset doubles, count doubles, and current moves to the next of the after cursor */
            if(count == 0){
                offset *= 2;
                count = offset;
                current = after + 1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] res = new Counting_Bits().countBits(8);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
