package NeetCode150;

import tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeOfBST {

    public String recserialize(TreeNode root, String str) {

        if (root == null) {
            str += "null,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = recserialize(root.left, str);
            str = recserialize(root.right, str);
        }

        return str;
    }

    public String serialize(TreeNode root) {
        return recserialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode recdeserialize(List<String> strs) {

        if (strs.get(0).equals("null")) {
            strs.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(strs.get(0)));
        strs.remove(0);

        root.left = recdeserialize(strs);
        root.right = recdeserialize(strs);

        return root;
    }

    public TreeNode deserialize(String data) {

        String[] strArray = data.split(",");
        List<String> strList =
                new LinkedList<String>(Arrays.asList(strArray));

        return recdeserialize(strList);
    }
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "null";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                TreeNode curr = q.poll();

                if (curr == null) {
                    sb.append("null,");
                    continue;
                }

                sb.append(curr.val).append(",");
                q.add(curr.left);
                q.add(curr.right);
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("null")) return null;

            String[] arr = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int i = 1;

            while (!q.isEmpty() && i < arr.length) {
                TreeNode curr = q.poll();

                if (!arr[i].equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(curr.left);
                }
                i++;

                if (i < arr.length && !arr[i].equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(curr.right);
                }
                i++;
            }

            return root;
        }
    }
}
