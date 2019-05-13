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
    /**
     * Find the kth smallest element in the BST.
     * @param root          Root of the BST.
     * @param k             kth element.
     * @return              The value of the kth element.
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> store = new ArrayList<>();
        helperFindKthSmallest(root, store);

        return store.get(k-1);
    }

    /**
     * Helper function to traverse the tree using inorder and store all the value in the given array list.
     * @param root          Root of the BST to be traversed.
     * @param store         The array list used for storing values.
     */
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