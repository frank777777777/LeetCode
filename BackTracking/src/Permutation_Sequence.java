import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.*/
public class Permutation_Sequence {

    /* working implementation, but it is too slow */
//    int count = 0;
//    List<Integer> permutation;
//    public String getPermutation(int n, int k) {
//        count = k;
////        List<List<Integer>> permutations = new ArrayList<>();
//        getPermutationHelper(new boolean[n + 1], new ArrayList<>());
//        StringBuilder sb = new StringBuilder();
//        for(Integer i : permutation){
//            sb.append(i);
//        }
//        return sb.toString();
//    }
//    private boolean getPermutationHelper(boolean[] used, List<Integer> list){
//        if(list.size() == used.length - 1){
//            if(--count == 0){
//                permutation = list;
//                return true;
//            }
//        }
//        for(int i = 1; i <= used.length - 1; i++){
//            if(used[i]) continue;
//            list.add(i);
//            used[i] = true;
//            if(getPermutationHelper(used, list)){
//                return true;
//            }
//            list.remove(list.size() - 1);
//            used[i] = false;
//        }
//        return false;
//    }

    public String getPermutation(int n, int k){
        /* compute factorial for later use */
        int[] factorial = new int[k + 1];
        factorial[0] = 1;
        for(int i = 1; i <= k; i++){
            factorial[i] = i * factorial[i - 1];
        }
        /* put 1 to n into a list */
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        /* build the string */
        StringBuilder sb = new StringBuilder();
        /* the first value has factorial[n - 1] permutation, the one after has factorial[n - 2], goes on and on */
        while(n > 0){
            int index = k / factorial[n - 1];
            sb.append(list.get(index));
            list.remove(index);
            k -= factorial[n - 1] * index;
            n--;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(new Permutation_Sequence().getPermutation(4, 3));
    }
}
