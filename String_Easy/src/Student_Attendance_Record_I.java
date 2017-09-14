/**
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:
 Input: "PPALLP"
 Output: True
 Example 2:
 Input: "PPALLL"
 Output: False
 */
public class Student_Attendance_Record_I {
    public boolean checkRecord(String s) {
        char[] mychar = s.toCharArray();
        int count_A=0;
        /* loop through all chars, if A is greater than 1, stop looping and return false */
        for(int i=0; i<s.length(); i++){
            if(mychar[i]=='A')
                count_A++;
            if(count_A>1)
                return false;
        }

        /* check every consecutive three position, if found any, stop looping and return false */
        for(int i=2; i<s.length(); i++){
            if(mychar[i-2]=='L' && mychar[i-1]=='L' && mychar[i]=='L')
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        String test_false = "PPALLL";
        String test_true = "PPALLP";

        System.out.print(new Student_Attendance_Record_I().checkRecord(test_false)+"\n");
        System.out.print(new Student_Attendance_Record_I().checkRecord(test_true));
    }
}
