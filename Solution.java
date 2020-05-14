import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

//public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }
//public class ListNode {
//    int               val;
//    Solution.ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}
class Solution {

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ret = new Integer[nums.length];
        Arrays.fill(ret, 0);
        TreeNode root=null;
        for (int i = nums.length-1; i >= 0; i--) {
            root=insert(root, new TreeNode(nums[i]),ret, i);
        }
        return Arrays.asList(ret);
    }

    private TreeNode insert(TreeNode root,TreeNode node,Integer[] res,int i){
        if(root==null){
            root=node;
            return root;
        }
        if(root.val>=node.val){
            root.count++;
            root.left=insert(root.left, node, res, i);
        }else {
            res[i]+=root.count+1;
            root.right=insert(root.right, node, res, i);
        }
        return root;
    }

    public class TreeNode {
        int val;
        int count;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; count=0;}
    }

}

