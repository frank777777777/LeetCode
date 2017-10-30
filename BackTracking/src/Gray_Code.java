import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2*/
public class Gray_Code {
    /* for every iteration, except the highest bit, the others bits are symmetric. The highest bit is first half 0 and second half 1 */
    public List<Integer> grayCode(int n) {
        List<Integer> grayCodes = new ArrayList<>();
        grayCodes.add(0);
        for(int i = 0; i < n; i++){
            int index = grayCodes.size() - 1;
            while(index >= 0){
                int bit = 1 << i;
                grayCodes.add(grayCodes.get(index) | bit);
                index--;
            }
        }
        return grayCodes;
    }

    public static void main(String[] args){
        Gray_Code gc = new Gray_Code();
        List<Integer> list = gc.grayCode(3);
        System.out.print(list.toString());
    }
}
