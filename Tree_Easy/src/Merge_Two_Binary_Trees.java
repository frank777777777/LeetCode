import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

 You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

 Example 1:
 Input:
 Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
 Output:
 Merged tree:
                    3
                   / \
                 4   5
                / \   \
               5   4   7
 Note: The merging process must start from the root nodes of both trees.
 */
public class Merge_Two_Binary_Trees {
    /* this method create a new tree, and leave the input unchanged. If we can alter the input. This code will be shorter*/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode new_node=null;
        new_node = merge(t1,t2,new_node);
        return new_node;
    }
    /* merge the value of t1 and t2, to the newly created new_node */
    private TreeNode merge(TreeNode t1, TreeNode t2, TreeNode new_node){
        if(t1==null && t2==null){
            return null;
        }else if(t1==null){
            return deep_copy(t2);
        }else if(t2==null){
            return deep_copy(t1);
        }
        new_node= new TreeNode(t1.val+t2.val);
        new_node.left = merge(t1.left,t2.left,new_node.left);
        new_node.right = merge(t1.right,t2.right,new_node.right);
        return new_node;
    }
    /* deep copy every node, and return the reference of the new root */
    private TreeNode deep_copy(TreeNode node){
        if(node==null)
            return null;
        TreeNode new_node = new TreeNode(node.val);
        new_node.left = deep_copy(node.left);
        new_node.right = deep_copy(node.right);
        return new_node;
    }
    public static void main(String[] args){
        Integer[] nums1 = {1,3};
        Integer[] nums2 = {2,1};
        TreeNode root1 = new Build_Tree().build(nums1);
        TreeNode root2 = new Build_Tree().build(nums2);
        TreeNode root3 = new Merge_Two_Binary_Trees().mergeTrees(root1,root2);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root3);
        TreeNode temp;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
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
