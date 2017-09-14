import java.util.HashMap;
import java.util.LinkedList;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

 You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

 Example 1:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 Output: ["Shogun"]
 Explanation: The only restaurant they both like is "Shogun".
 Example 2:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["KFC", "Shogun", "Burger King"]
 Output: ["Shogun"]
 Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 Note:
 The length of both lists will be in the range of [1, 1000].
 The length of strings in both lists will be in the range of [1, 30].
 The index is starting from 0 to the list length minus 1.
 No duplicates in both lists.
 */
public class Minimum_Index_SUm_of_Two_Lists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> list1_hash = new HashMap<>();
        /* put all String in list1 and its corresponding index to hashmap */
        for(int i=0;i<list1.length;i++){
            list1_hash.put(list1[i],i);
        }
        /* min_index_sum keep track on the min sum of index. index sum is a transient variable to store the current
        * result of index sum. count stores the number of duplicate common String min sum of indexes */
        int min_index_sum= Integer.MAX_VALUE;
        int index_sum;
        LinkedList<String> common_list = new LinkedList<>();
        /* When i iterate to the end of list2, OR, it has already reaches to the min_index_sum, therefore
        * we can terminate ealier */
        for(int i=0;i<list2.length && i<=min_index_sum;i++){
            if(list1_hash.containsKey(list2[i])){
                index_sum = list1_hash.get(list2[i])+i;
                if(index_sum<min_index_sum){
                    common_list.clear();
                    common_list.add(0,list2[i]);
                    min_index_sum=index_sum;
                }else if(index_sum==min_index_sum){
                    common_list.add(0,list2[i]);
                }
            }
        }
        return common_list.toArray(new String[0]);
    }

    public static void main(String[] args){
        String[] s = {"Shogun", "KFC","Tapioca Express", "Burger King"};
        String[] t = {"KFC", "Shogun", "Burger King"};
        String[] result = new Minimum_Index_SUm_of_Two_Lists().findRestaurant(s,t);
        for(String str:result)
            System.out.print(str+" ");
    }
}
