package Trees;

public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftCount = maxDepth(root.left);
            int rightCount = maxDepth(root.right);
            return 1 + Math.max(leftCount,rightCount);
        }
    }

    public static void main(String[] args) {
//[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);

        System.out.println(maxDepth(root));
    }
}
