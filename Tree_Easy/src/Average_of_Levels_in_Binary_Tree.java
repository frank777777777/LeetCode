import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

 Example 1:
 Input:
                  3
                 / \
                9  20
                  /  \
                 15   7
 Output: [3, 14.5, 11]
 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 Note:
 The range of node's value is in the range of 32-bit signed integer.
 */
public class Average_of_Levels_in_Binary_Tree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        /* breath first search,*/
        while (!queue.isEmpty()){
            int size = queue.size();
            int iteration = size;
            double sum=0;
            /* every while loop is a level, sum all up, and divide by its size later. Put it in the list to return */
            while(iteration-- >0){
                temp = queue.poll();
                sum += temp.val;
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
            res.add(sum/size);
        }
        return res;
    }
    public static void main(String[] args){
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root= new Build_Tree().build(nums);
        List<Double> list = new Average_of_Levels_in_Binary_Tree().averageOfLevels(root);
        Iterator<Double> itr = list.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }
}
