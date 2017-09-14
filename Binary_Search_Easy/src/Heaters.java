import java.util.ArrayList;
import java.util.Arrays;

/**
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

 Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

 So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

 Note:
 Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 As long as a house is in the heaters' warm radius range, it can be warmed.
 All the heaters follow your radius standard and the warm radius will the same.
 Example 1:
 Input: [1,2,3],[2]
 Output: 1
 Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 Example 2:
 Input: [1,2,3,4],[1,4]
 Output: 1
 Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.*/
public class Heaters {
    /* The idea is, for each house, find the nearest heater for it. The maximum value of the nearest heater for each house is the minimum radius */
    public int findRadius(int[] houses, int[] heaters) {
        /* sort them first */
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, res = 0;
        for(int house : houses){
            /* heaters.length-1 is the index of the second last heater index, because the very last heater index dose not have next heater */
            /* (heaters[i]+heaters[i+1])/2 is the mid of the two heaters, if it is less than house, heater[i] is closer than house, otherwise heater[i+1] is closer */
            while(i < heaters.length - 1 && heaters[i] + heaters[i+1] < 2 * house){
                i++;
            }

            res = Math.max(res,Math.abs(house-heaters[i]));
        }
        return res;
    }
    public static void main(String[] args){
        int[] houses = new int[]{1,3,7,8};
        int[] heaters = new int[]{3,7};
        System.out.println(new Heaters().findRadius(houses,heaters));
    }
}
