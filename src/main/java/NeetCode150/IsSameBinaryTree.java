package NeetCode150;

public class IsSameBinaryTree {
    public boolean isSameTree(InvertBinaryTree.TreeNode p, InvertBinaryTree.TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
