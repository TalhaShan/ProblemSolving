package Trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        } else {

            res.addAll(inorderTraversal(root.left));
            res.add(root.val);
            res.addAll(inorderTraversal(root.right));
            return res;
        }
    }

}

