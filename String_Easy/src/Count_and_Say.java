/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:

 Input: 1
 Output: "1"
 Example 2:

 Input: 4
 Output: "1211"
 */
public class Count_and_Say {
    public String countAndSay(int n) {
        /* initialization */
        StringBuilder strb = new StringBuilder("1");

        /* loop n-1 times */
        for(int i=1; i<n; i++){
            strb = say(strb);
        }
        return String.valueOf(strb);

    }
    public StringBuilder say(StringBuilder strb){
        /* add an empty tailing ,to avoid index out of range */
        strb.append(' ');
        StringBuilder new_str = new StringBuilder("");
        /* initialize the values at index 0 */
        int counter=1;
        char previous=strb.charAt(0);

        /* if the value is different than the previous, append the number of char, append the char it self. Or else, keep looping and counting until the next different value,
        *  Because I added and empty tail at the end, so as to handle the boundary condition */
        for(int i=1; i<strb.length(); i++){
            /* Whenever the char value changes, we append stuff */
            if(strb.charAt(i) != previous){
                new_str.append(String.valueOf(counter));
                new_str.append(previous);
                counter=1;
            }
            /* Or keep looping and count, keeping track of the previous char*/
            else
                counter++;
            previous = strb.charAt(i);
        }
        return new_str;
    }

    public static void main(String[] args){
        int i=10;
        System.out.print(new Count_and_Say().countAndSay(i));
    }
}
