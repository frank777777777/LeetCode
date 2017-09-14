import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

           10
          /  \
         5   -3
        / \    \
       3   2   11
      / \   \
     3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11
 */
public class Path_Sum_III {
    /* Try every nodes, from top to button */
//    public int pathSum(TreeNode root, int sum) {
//        if(root==null)
//            return 0;
//        /* iteration version */
////        Stack<TreeNode> stack = new Stack<>();
////        stack.push(root);
////        TreeNode temp;
////        int count=0;
////        while(!stack.isEmpty()){
////            temp = stack.pop();
////            count+=dfs(temp,sum);
////            if(temp.right!=null)
////                stack.push(temp.right);
////            if(temp.left!=null)
////                stack.push(temp.left);
////        }
////        return count;
//        /* recursion version */
//        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//    }
//    /* use root as a starting poing, see count how many path can sum to target */
//    public int dfs(TreeNode root, int target){
//        if(root==null){
//            return 0;
//        }
//        if(target-root.val==0){
//            return 1+dfs(root.left,target-root.val)+dfs(root.right,target-root.val);
//        } else {
//            return dfs(root.left,target-root.val)+dfs(root.right,target-root.val);
//        }
//    }
    /* */
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        /* key is the prefix sum from the root to the current node, value is its frequency */
        HashMap<Integer,Integer> map = new HashMap<>();
        /* currently 0 appeared once */
        map.put(0,1);
        return findPathSum(root,0,sum,map);
    }
    private int findPathSum(TreeNode node, int sum, int target, Map<Integer, Integer> map) {
        if(node==null)
            return 0;
        /* the sum from the root to this node */
        sum+=node.val;
        /* there are path number of path from somewhere from the middle to the current node.
        * Since if sum-target exist, then the diff value, will be sum-diff=target, which we have a path */
        int path = map.getOrDefault(sum-target,0);
        /* put the current sum in the map, increment the appearance. */
        map.put(sum,map.getOrDefault(sum,0)+1);
        /* the path end with the current node, plus with his children */
        int res = path+findPathSum(node.left,sum,target,map)+findPathSum(node.right,sum,target,map);
        /* before going back, restore the map, since the sum appearance only happens in this level, not when gone back
        * to the up level*/
        map.put(sum,map.get(sum)-1);
        return res;

    }

    public static void main(String[] args){
        Integer[] nums = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = new Build_Tree().build(nums);
        System.out.print(new Path_Sum_III().pathSum(root,8));
    }
}
