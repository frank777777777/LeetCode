import java.util.*;

/**
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max_depth = 0;
        /* If there is no children in this level, means this is the max depth */
        while(!queue.isEmpty()){
            int size = queue.size();
            /* loop through the entire level, add their children if present */
            while (size-- >0){
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            max_depth++;
        }
        return max_depth;
    }


    public static void main(String[] args){
        Integer[] nums = {1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5};
        TreeNode root = new Build_Tree().build(nums);
        System.out.print(new Maximum_Depth_of_Binary_Tree().maxDepth(root));
    }


    /* Using stack, depth first search */
//    public int maxDepth(TreeNode root) {
//        if(root==null)
//            return 0;
//        int max=1;
//        /* stack keep track on nodes, and depth keep track on the current depth it is, they always pop and push together */
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<Integer> depth = new Stack<>();
//        /* push first node*/
//        stack.push(root);
//        depth.push(1);
//        while(!stack.isEmpty()){
//            /* pop the current node and depth, check it it is greater than the max */
//            TreeNode node = stack.pop();
//            Integer current = depth.pop();
//            max = current>max ? current : max;
//            /* push left or/and right children if present */
//            if(node.right!=null){
//                stack.push(node.right);
//                depth.push(current+1);
//            }
//            if(node.left!=null){
//                stack.push(node.left);
//                depth.push(current+1);
//            }
//        }
//        return max;
//    }


/* Recursive call*/
//    public int maxDepth(TreeNode root){
//        if(root==null)
//            return 0;
//        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
//    }






}




