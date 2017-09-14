/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int length = s.length();
        int i=0, j=length-1;
        while(i<length && j>-1){
            while(i<length && !alphanumeric(s.charAt(i)))
                i++;
            while(j>-1 && !alphanumeric(s.charAt(j)))
                j--;
            if(!(i<length || j>-1))
                break;
            if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                i++;j--;
            }
            else
                return false;
        }
        return true;
    }

    private boolean alphanumeric(char c){
        if(c>='0' && c<='9') return true;
        if(c>='a' && c<='z') return true;
        if(c>='A' && c<='Z') return true;
        return false;
    }

/* Working code yet slow. Ssing regular expression to get rid of non alphanumerics in the string, convert it to lower case, and then compare from the head to the tail in both ways */
//    public boolean isPalindrome(String s) {
//        String new_str = s.toLowerCase().replaceAll("\\W+","");
//        int length = new_str.length();
//        if(length==0)
//            return true;
//        for(int i=0;i<length;i++){
//            if(new_str.charAt(i)!=new_str.charAt(length-1-i))
//                return false;
//        }
//        return true;
//    }
    public static void main(String[] args){
        String test = "0P";
        System.out.print(new Valid_Palindrome().isPalindrome(test));
    }
}
