/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.*/
public class Climbing_Stairs {
    public int climbStairs(int n) {
        /* invalid input */
        if(n < 1){
            return 0;
        }
        int[] steps = new int[n+1];
        int backOne;
        int backTwo;
        steps[0] = 1;
        /* the current ways of climbing to this step is the sum of the previous two steps */
        for(int i = 1; i < steps.length; i++){
            backOne = i - 1 >= 0 ? steps[i-1] : 0;
            backTwo = i - 2 >= 0 ? steps[i-2] : 0;
            steps[i] = backOne + backTwo;
        }
        return steps[n];
    }
    public static void main(String[] args){
        System.out.println(new Climbing_Stairs().climbStairs(4));
    }
}
