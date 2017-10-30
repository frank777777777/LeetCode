
import java.util.*;

/**
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]*/
public class Combination_Sum_III {

    /* working, but too slow */
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        int[] used = new int[10];
//        Set<List<Integer>> set = new HashSet<>();
//        List<Integer> numbers = new ArrayList<>();
//        combinationSumHelper(used, k, n ,set, numbers);
//        /* not duplicate in set, converse it back to list */
//        List<List<Integer>> combinations = new ArrayList<>(set);
//        return combinations;
//    }
//
//    private void combinationSumHelper(int[] used, int rec, int sum, Set<List<Integer>> set, List<Integer> numbers){
//        if(rec < 0) return;
//        if(rec == 0 && sum == 0){
//            /* to reduce duplicate List<Integer> */
//            Collections.sort(numbers);
//            set.add(numbers);
//        }
//        for(int i = 1; i <= 9; i++){
//            if(sum - i < 0) continue;
//            if(used[i] == 0){
//                used[i] = 1;
//                List<Integer> newList = new ArrayList<>(numbers);
//                newList.add(i);
//                combinationSumHelper(used, rec - 1, sum - i, set, newList);
//                used[i] = 0;
//            }
//        }
//    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new LinkedList<>();
        List<Integer> numbers = new LinkedList<>();
        combinationSumHelper(numbers, combinations, 1, k, n);
        return combinations;

    }

    private void combinationSumHelper(List<Integer> numbers, List<List<Integer>> combinations, int start, int k, int n){
        if(k == 0 && n == 0){
            combinations.add(new LinkedList<>(numbers));
            return;
        }else if(k == 0 || n < 0){
            return;
        }

        for(int i = start; i <= 9; i++){
            numbers.add(0,i);
            combinationSumHelper(numbers, combinations, i + 1, k - 1, n - i);
            numbers.remove(0);
        }
    }

    public static void main(String[] args){
        Combination_Sum_III test = new Combination_Sum_III();
        List<List<Integer>> res = test.combinationSum3(3,7);
        for(List<Integer> l : res){
            System.out.println(l.toString());
        }
    }
}
