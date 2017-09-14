/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]
 */
public class Reverse_String_II {
    public String reverseStr(String s, int k) {
        char[] str_chars = s.toCharArray();
        int iteration = s.length()/(2*k);
        int remainder = s.length()%(2*k);
        for(int i=0; i<iteration; i++){
            reverse(str_chars, i*2*k, i*2*k+k-1);
        }
        if(remainder>k){
            reverse(str_chars, iteration*2*k, iteration*2*k+k-1);
        }
        else {
            reverse(str_chars, iteration*2*k, iteration*2*k+remainder-1);
        }
        return String.valueOf(str_chars);

    }

    public void reverse(char[] str_chars, int begin, int end){
        char temp;
        /* swap both two ends, until the indexes converges */
        while(begin < end){
            temp = str_chars[begin];
            str_chars[begin] = str_chars[end];
            str_chars[end] = temp;
            begin++; end--;
        }
    }
    public static void main(String[] args){
        String test = "abcdefg";
        String result = new Reverse_String_II().reverseStr(test,2);
        System.out.print(result);
    }
}
