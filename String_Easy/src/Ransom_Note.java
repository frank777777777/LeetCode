/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

 Each letter in the magazine string can only be used once in your ransom note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 */
public class Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        char [] magazine_char = magazine.toCharArray();
        char [] ransomNote_char = ransomNote.toCharArray();
        for(int i =0; i<ransomNote_char.length; i++){
            boolean flag = false;
            for(int j=0; j<magazine_char.length; j++){
                if(ransomNote_char[i] == magazine_char[j]){
                    flag = true;
                    magazine_char[j]='0';
                    break;
                }
            }
            if(flag == false)
                return flag;
        }
        return true;
    }

    public static void main(String[] args){
        String test = "ab";
        String magazine = "aabb";
        System.out.print(new Ransom_Note().canConstruct(test, magazine));
    }
}
