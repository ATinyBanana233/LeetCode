/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> store = new ArrayList<>();
        helperFindKthSmallest(root, store);
        return store.get(k-1);
    }

    public void helperFindKthSmallest(TreeNode root, List<Integer> store) {
        if (root == null)
        {
            return;
        }
        helperFindKthSmallest(root.left, store);
        store.add(root.val);
        helperFindKthSmallest(root.right, store);
    }
}