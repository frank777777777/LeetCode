import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/
public class Restore_IP_Address {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIpAddressesHelper(0, res, new ArrayList<>(), s);
        return res;
    }
    private void restoreIpAddressesHelper(int pos, List<String> res, List<String> list, String s){
        /* if the size is greater than 4, just return already */
        if(list.size() > 4) return;
        /* only when the size is 4 and pos reaches the end, it is a valid address */
        if(list.size() == 4 && pos == s.length()){
            String temp = list.get(0) + "." + list.get(1) + "." + list.get(2) + "." + list.get(3);
            res.add(temp);
        }
        for(int i = 1; i <= 3 && pos + i <= s.length(); i++){
            String substr = s.substring(pos, pos + i);
            if(!isValid(substr)) break;
            list.add(substr);
            restoreIpAddressesHelper(pos + i, res, list, s);
            list.remove(list.size() - 1);
        }
    }
    /* is the subtring a valid ip */
    private boolean isValid(String str){
        Integer value = Integer.valueOf(str);
        if(value < 0 || value > 255 || !value.toString().equals(str)){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        List<String> list = new Restore_IP_Address().restoreIpAddresses("010010");
        for(String str : list){
            System.out.println(str);
        }
    }
}
