package leetCode.tree;

/**
 * 相同的树
 *
 * @author moubin.mo
 * @date: 2019/9/17 21:24
 */

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
	public static void main(String[] args) {
		TreeNode p = getATree();
		TreeNode q = getATreeV2();
		System.out.println("result = " + isSameTree(p, q));

	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	/**
	 * 创建一棵树
	 */
	public static TreeNode getATree() {
		TreeNode headNode = new TreeNode(1);
		TreeNode leftNode = new TreeNode(2);
		TreeNode rightNode = new TreeNode(3);
		headNode.setLeft(leftNode);
		headNode.setRight(rightNode);
		return headNode;
	}

	public static TreeNode getATreeV2() {
		TreeNode headNode = new TreeNode(1);
		TreeNode leftNode = new TreeNode(2);
		TreeNode rightNode = new TreeNode(3);
		headNode.setLeft(leftNode);
		headNode.setRight(rightNode);
		return headNode;
	}

}
