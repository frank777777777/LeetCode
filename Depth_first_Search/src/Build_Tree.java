import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class just provide method that build a binary tree for testing purpose of other class.
 * It does not guarantee error safe it the input array cannot be built to a binary tree
 */
public class Build_Tree {
    public TreeNode build(Integer[] arr){
        if(arr.length==0 || arr[0]==null)
            return null;
        /* Build a queue, do breadth search to build the binary tree */
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(arr[0]);
        queue.offer(head);
        int i=1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
                TreeNode node = queue.poll();
                if(i>arr.length-1 || arr[i]==null){
                    i++;
                } else {
                    node.left = new TreeNode(arr[i++]);
                    queue.offer(node.left);
                }
                if(i>arr.length-1 || arr[i]==null){
                    i++;
                } else {
                    node.right = new TreeNode(arr[i++]);
                    queue.offer(node.right);
                }
            }
        }
        return head;
    }

    public static void main(String[] args){
        Integer[] arr = {1,2,2,null,3,null,3};

        TreeNode root = new Build_Tree().build(arr);
        int i=0;
    }
}
