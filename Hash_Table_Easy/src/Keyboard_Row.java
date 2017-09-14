import java.util.LinkedList;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


 American keyboard


 Example 1:
 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]
 Note:
 You may use one character in the keyboard more than once.
 You may assume the input string will only contain letters of alphabet.
 */
public class Keyboard_Row {
    /* the map stores each char and its responding row number */
    static final int[] map= new int[256];
    static {
        char[] row_1 = {'q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P'};
        char[] row_2 = {'a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L'};
        char[] row_3 = {'z','x','c','v','b','n','m','Z','X','C','V','B','N','M'};
        for(char e: row_1)
            map[e]=1;
        for(char e: row_2)
            map[e]=2;
        for(char e: row_3)
            map[e]=3;
    }
    public String[] findWords(String[] words) {
        LinkedList<String> list = new LinkedList<>();
        for(String word:words){
            boolean flag=true;
            /* get the row number of the first char, and loop to see it the following row number are the same */
            int rowNo=map[word.charAt(0)];
            for(int i=1;i<word.length();i++){
                if(rowNo!=map[word.charAt(i)]){
                    flag=false;
                    break;
                }
            }
            if(flag==true)
                list.add(word);
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args){
        String[] strs = {"Hello", "Alaska", "Dad", "Peace"};
        String[] new_strs = new Keyboard_Row().findWords(strs);
        for(String str:new_strs){
            System.out.print(str+" ");
        }
    }
}
