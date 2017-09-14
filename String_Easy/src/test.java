/**
 * just testing
 */
public class test {
    private static final int[]charMap = new int[256];
//    static{
//        for(int i=0;i<10;i++){
//            charMap[i+'0'] = (char)(1+i);  // numeric
//        }
//        for(int i=0;i<26;i++){
//            charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
//        }
//    }
    public boolean isPalindrome(String s) {
        char[]pChars = s.toCharArray();
        int start = 0,end=pChars.length-1;
        int cS,cE;
        while(start<end){
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if(cS!=0 && cE!=0){
                if(cS!=cE)return false;
                start++;
                end--;
            }else{
                if(cS==0)start++;
                if(cE==0)end--;
            }
        }
        return true;
    }

    public static void main(String[] args){

        for(int i=0;i<10;i++){
            charMap[i+'0'] = (1+i);  // numeric
        }
        for(int i=0;i<26;i++){
            charMap[i+'a'] = charMap[i+'A'] = (11+i);  //alphabetic, ignore cases
        }
        String test = "aa";

        System.out.print(new test().isPalindrome(test));
    }

}
