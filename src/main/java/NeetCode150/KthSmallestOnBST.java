package NeetCode150;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestOnBST {
    public int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> nums = inOrder(root, new ArrayList<>());
        return nums.get(k - 1);

    }

    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
        return arr;
    }
}
