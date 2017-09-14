import sun.reflect.generics.tree.Tree;
import sun.swing.SwingUtilities2;

/**
 * Find the sum of all left leaves in a given binary tree.

 Example:

        3
       / \
      9  20
        /  \
       15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Sum_of_Left_Leaves {
    /* Working code */
//    public int sumOfLeftLeaves(TreeNode root) {
//        int sum=0;
//        if(root==null)
//            return sum;
//        sum+= sumOfLeftLeaves_helper(root,false,sum);
//        return sum;
//    }
//    public int sumOfLeftLeaves_helper(TreeNode node, Boolean is_left, int sum){
//        int sum_l=0,sum_r=0;
//        if(node.left!=null){
//            sum_l+= sumOfLeftLeaves_helper(node.left,true,sum_l);
//        }
//        if(node.left==null && node.right==null){
//            if(is_left)
//                return node.val;
//            else
//                return 0;
//        }
//        if(node.right!=null){
//            sum_r+= sumOfLeftLeaves_helper(node.right,false,sum_r);
//        }
//        return sum+sum_l+sum_r;
//    }

    /* Another way, every time check if the left child is a leaf, if yes, sum it, or else goes down to the left
    * or the right */
    public int sumOfLeftLeaves(TreeNode root){
        int sum=0;
        if(root==null)
            return 0;
        sum = sumOfLeftLeaves_helper(root,sum);
        return sum;
    }
    public int sumOfLeftLeaves_helper(TreeNode node, int sum){
        int sum_1=0,sum_r=0;
        if(node.left!=null){
            if(node.left.left==null && node.left.right==null){
                sum_1 = node.left.val;
            }else{
                sum_1 = sumOfLeftLeaves_helper(node.left,sum);
            }
        }
        if(node.right!=null){
            sum_r = sumOfLeftLeaves_helper(node.right,sum);
        }
        return sum+sum_1+sum_r;
    }
    public static void main(String[] args){
        Integer[] nums={3,9,20,null,null,15,7};
        TreeNode root = new Build_Tree().build(nums);
        System.out.print(new Sum_of_Left_Leaves().sumOfLeftLeaves(root));
    }

}
