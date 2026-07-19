package NeetCode150;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null){
                return result;
            }

            order(root,0);
            return result;
    }

    public void order(TreeNode node, int level){
        if(result.size()==level){
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        if(node.left!=null){
            order(node.left,level+1);
        }
        if(node.right!=null){
            order(node.right,level+1);
        }
    }
}
