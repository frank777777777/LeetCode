import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.

 However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

 You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

 Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.

 You could use any of special offers as many times as you want.

 Example 1:
 Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
 Output: 14
 Explanation:
 There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
 In special offer 1, you can pay $5 for 3A and 0B
 In special offer 2, you can pay $10 for 1A and 2B.
 You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
 Example 2:
 Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 Output: 11
 Explanation:
 The price of A is $2, and $3 for B, $4 for C.
 You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
 You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
 You cannot add more items, though only $9 for 2A ,2B and 1C.
 Note:
 There are at most 6 kinds of items, 100 special offers.
 For each item, you need to buy at most 6 of them.
 You are not allowed to buy more items than you want, even if that would lower the overall price.*/
public class Shopping_Offers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        /* convert those lists to ArrayList */
        ArrayList<Integer> ALprice = new ArrayList<>(price);
        ArrayList<List<Integer>> ALspecial = new ArrayList<>();
        for(List<Integer> list : special){
            ALspecial.add(new ArrayList<>(list));
        }
        ArrayList<Integer> ALneeds = new ArrayList<>(needs);
        HashMap<List<Integer>, Integer> dp = new HashMap<>();
        List<Integer> dpBase = new ArrayList<>();
        /* when the need for every item is 0 */
        for(Integer i : needs){
            dpBase.add(0);
        }
        dp.put(dpBase,0);
        int res = dfs(ALprice, ALspecial, ALneeds, dp);
        return res;

    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, HashMap<List<Integer>, Integer> dp){
        /* if we calculated the minimum price already, just return */
        if(dp.containsKey(needs)){ return dp.get(needs); }
        int res = Integer.MAX_VALUE;
        int temp;
        for(List<Integer> sp : special){
            /* a copy of new needs, the original needs minus the special applies */
            ArrayList<Integer> needCP = new ArrayList<>();
            boolean isValid = true;
            for(int i = 0; i < needs.size(); i++){
                temp = needs.get(i) - sp.get(i); // is temp is less than 0, which means we are taking more than we need in this offer, thus inValid
                needCP.add(temp);
                if(temp < 0){ isValid = false; break;}
            }
            if(!isValid){ continue; } // the current special is not valid, continue and try next
            /* sp.get(needs.size()) get the cost for the offer, which is the last in the list, plus the dfs for the new needs */
            res = Math.min(res, sp.get(needs.size()) + dfs(price, special, needCP, dp));
        }

        /* if we do not use special */
        int regularCost = 0;
        for(int i = 0; i < needs.size(); i++){
            regularCost += needs.get(i) * price.get(i);
        }
        /* the minimum between use special and just pay regular, and put it into dp */
        res = Math.min(res, regularCost);
        dp.put(needs, res);
        return res;
    }

    public static void main(String[] args){
        List<Integer> price = Arrays.asList(2,3,4);
        List<Integer> special1 = Arrays.asList(1,1,0,4);
        List<Integer> special2 = Arrays.asList(2,2,1,9);
        List<List<Integer>> special = Arrays.asList(special1,special2);
        List<Integer> needs = Arrays.asList(1,2,1);
        System.out.print(new Shopping_Offers().shoppingOffers(price, special, needs));

    }
}
