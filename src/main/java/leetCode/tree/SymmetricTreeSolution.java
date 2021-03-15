package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * @author moubin.mo
 * @date: 2019/9/18 21:40
 */

public class SymmetricTreeSolution {

	public static void main(String[] args) {
		TreeNode aTree = getATree();
		System.out.println("result = " + isSymmetric(aTree));
		System.out.println("result = " + isSymmetricVIteration(aTree));
	}

	/**
	 * 迭代-队列
	 */
	public static boolean isSymmetricVIteration(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode t1 = queue.poll();
			TreeNode t2 = queue.poll();
			if (t1 == null && t2 == null) {
				continue;
			}
			if (t1 == null || t2 == null) {
				return false;
			}
			if (t1.val != t2.val) {
				return false;
			}
			queue.add(t1.left);
			queue.add(t2.right);
			queue.add(t1.right);
			queue.add(t2.left);
		}
		return true;
	}

	/**
	 * 递归方法
	 */
	public static boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}

		if (root.left == null && root.right == null) {
			return true;
		}

		if (root.left != null && root.right != null) {
			return isSymmetric(root.left, root.right) && isSymmetric(root.right, root.left);
		}

		return false;
	}

	public static boolean isSymmetric(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		if (node1.val == node2.val) {
			return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
		}

		return false;
	}

	/**
	 * 创建一棵树
	 */
	public static TreeNode getATree() {
		TreeNode headNode = new TreeNode(1);

		// 第一场节点
		TreeNode leftNode = new TreeNode(2);
		TreeNode rightNode = new TreeNode(3);

		// 第二层节点
		TreeNode leftChild1Node = new TreeNode(3);
		TreeNode leftChild2Node = new TreeNode(4);
		TreeNode rightChild1Node = new TreeNode(3);
		TreeNode rightChild2Node = new TreeNode(4);

//		leftNode.left = leftChild1Node;
//		leftNode.right = leftChild2Node;
//		rightNode.left = rightChild2Node;
//		rightNode.right = rightChild1Node;

		headNode.setLeft(leftNode);
		headNode.setRight(rightNode);
		return headNode;
	}

}
