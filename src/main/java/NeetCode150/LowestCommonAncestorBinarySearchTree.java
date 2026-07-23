package NeetCode150;

public class LowestCommonAncestorBinarySearchTree {

    public class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,  TreeNode left,  TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int parentval = root.val;
        int pVal= p.val;
        int qVal = q.val;

        if(pVal > parentval && qVal > parentval){
            return lowestCommonAncestor(root.right, p, q);
        }
        if(pVal<parentval && qVal<parentval){
            return lowestCommonAncestor(root.left, p, q);
        }

        else{
            return root;
        }
    }
}
