import com.sun.org.apache.regexp.internal.RE;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
          5
        /   \
       2     13

 Output: The root of a Greater Tree like this:
         18
        /   \
      20     13
 */
public class Convert_BST_to_Greater_Tree {
    int pre=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return null;
        Reverse_in_order_search(root);
        return root;
    }
    public void Reverse_in_order_search(TreeNode node){
        if(node==null)
            return;
        Reverse_in_order_search(node.right);
        node.val = node.val+ pre;
        pre=node.val;
        Reverse_in_order_search(node.left);
        return;
    }
    public static void main(String[] args){
        Integer[] nums = {5,2,13,1,3,7,15};
        TreeNode root = new Build_Tree().build(nums);
        Deque<TreeNode> queue = new LinkedList<>();
        root = new Convert_BST_to_Greater_Tree().convertBST(root);
        queue.add(root);
        TreeNode temp;
        while ((!queue.isEmpty())){
            int size = queue.size();
            while (size-- >0){
                temp = queue.poll();
                System.out.print(temp.val+" ");
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            System.out.print("\n");
        }
    }
}
