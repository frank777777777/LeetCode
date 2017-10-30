
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.
 For example, the above binary watch reads "3:25".

 Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

 Example:

 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 Note:
 The order of output does not matter.
 The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".*/
public class Binary_Watch {
//    public List<String> readBinaryWatch(int num) {
//        List<String> res = new ArrayList<>();
//        int[] hours = {8,4,2,1}, minutes = {32,16,8,4,2,1};
//        List<Integer> hour, minute;
//        for(int i = 0; i <= num; i++){
//            hour = numberPermutation(hours, i);
//            minute = numberPermutation(minutes, num - i);
//            for(Integer h : hour){
//                if(h > 11) continue;
//                for(Integer m : minute){
//                    if(m > 59) continue;
//                    res.add(h + ":" + (m < 10 ? "0" + m : m));
//                }
//            }
//        }
//        return res;
//    }
//
//    private List<Integer> numberPermutation(int[] arr, int count){
//        LinkedList<Integer> res = new LinkedList<>();
//        int sum = 0, pos = 0;
//        numberPermutationHelper(arr, pos, sum, count, res);
//        return res;
//    }
//
//    private void numberPermutationHelper(int[] arr, int pos, int sum, int count, LinkedList<Integer> res){
//        if(count == 0){
//            res.add(sum);
//            return;
//        }
//
//        for(int i = pos; i < arr.length; i++){
//            numberPermutationHelper(arr,i + 1, sum + arr[i], count - 1, res);
//        }
//    }
public List<String> readBinaryWatch(int num) {
    List<String> ret = new ArrayList<>();
    dfs(ret, 0, num, 0);
    return ret;
}

    private void dfs(List<String> ret, int path, int num, int k) {
        int hr = (path & 0xF), min = (path & 0xFF0) >> 4;
        if (hr > 11 || min > 59) return;
        if (num == 0) {
            ret.add(hr + ":" + (min < 10 ? "0": "") + min);
        } else {
            for (int i = k; i < 10; i++) {
                int shift = 1 << i;
                int show_path = path;
                dfs(ret, (show_path | shift), num - 1, i + 1);
            }
        }
    }

    public static void main(String[] args){
        for(String s : new Binary_Watch().readBinaryWatch(1)){
            System.out.print(s + " ");
        }
    }
}
