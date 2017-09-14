/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

 Please note that the string does not contain any non-printable characters.
 */
public class Number_of_Segments_in_a_String {
    public int countSegments(String s) {
        char[] mychars = s.toCharArray();
        int counter =0;
        /* check if it is empty */
        if(mychars.length==0)
            return 0;
        /* check for it it starts off zero */
        if(mychars[0] != ' ')
            counter++;

        /* for every non-space preceded by a space, it is a count*/
        for(int i=1; i<mychars.length; i++){
            if(mychars[i] != ' ' && mychars[i-1]==' '){
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args){
        String test = "";
        System.out.print(new Number_of_Segments_in_a_String().countSegments(test));
    }
}
