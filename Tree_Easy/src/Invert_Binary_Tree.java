import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Invert a binary tree.

            4
          /   \
         2     7
        / \   / \
       1   3 6   9
            to
             4
           /   \
          7     2
         / \   / \
       9   6 3   1
 */
public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;
        return root;
    }
    public static void main(String[] args){
        Integer[] nums= {4,2,7,1,3,6,9};
        TreeNode root = new Build_Tree().build(nums);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(new Invert_Binary_Tree().invertTree(root));
        TreeNode temp;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
                temp = queue.pop();
                System.out.print(temp.val+"  ");
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            System.out.print("\n");
        }
    }
}
