import java.util.logging.Level;

/**
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

 The number at the ith position is divisible by i.
 i is divisible by the number at the ith position.
 Now given N, how many beautiful arrangements can you construct?

 Example 1:
 Input: 2
 Output: 2
 Explanation:

 The first beautiful arrangement is [1, 2]:

 Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

 Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

 The second beautiful arrangement is [2, 1]:

 Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

 Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 Note:
 N is a positive integer and will not exceed 15.*/
public class Beautiful_Arrangement {
    int arrangements;
    public int countArrangement(int N) {
        /* the arr indicating if the number is used or not. 0 is unused, 1 is used. */
        int[] arr = new int[N + 1];
        arrangementHelper(1, N, arr);
        return arrangements;


    }
    private void arrangementHelper(int index, int N, int[] arr){
        if(index > N){
            arrangements++;
            return;
        }
        for(int i = 1; i <= N; i++){
            if (arr[i] == 0 && (index % i == 0 || i % index == 0)){
                arr[i] = 1;
                arrangementHelper(index + 1, N, arr);
                arr[i] = 0; /* restore the value at this level */
            }
        }

    }

    public static void main(String[] args){
        System.out.println(new Beautiful_Arrangement().countArrangement(10));
    }
}
