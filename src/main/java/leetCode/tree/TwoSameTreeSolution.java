package leetCode.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * REMARK 相同的树
 *
 * @author: mmb
 * @date: 19-9-15
 */
public class TwoSameTreeSolution {

    public static void main(String[] args){
		TreeNode p = getATree();
//		TreeNode q = getATree();
		TreeNode q = getATreeV2();
		System.out.println("result = " + isSameTree(p, q));

	}

	/**
	 * 比较两棵树是否相同
	 */
    public static boolean isSameTree(TreeNode p, TreeNode q){
		List<Integer> tree1AllNodes = getAllNodes(p);
		List<Integer> tree2AllNodes = getAllNodes(q);
		System.out.println("tree1AllNodes = " + tree1AllNodes);
		System.out.println("tree2AllNodes = " + tree2AllNodes);
		return compareTwoTree(tree1AllNodes, tree2AllNodes);
    }

    /**
	 * 比较两棵树的结点列表
	 */
	private static boolean compareTwoTree(List<Integer> tree1AllNodes, List<Integer> tree2AllNodes) {
		// 两棵树的节点要一样
		if (tree1AllNodes.size() == tree2AllNodes.size()){
			int countTime = 0;
			int tree1NotNullCount = 0;
			int tree2NotNullCount = 0;
			Iterator<Integer> iterator1 = tree1AllNodes.iterator();
			Iterator<Integer> iterator2 = tree2AllNodes.iterator();
			// 逐个遍历两棵树的节点
			while (iterator1.hasNext()){
				Integer tree1Node = iterator1.next();
				Integer tree2Node = iterator2.next();

				// 两棵树的节点都不为空
				if (tree1Node != null && tree2Node != null){
					if (tree1Node.equals(tree2Node)){
						countTime++;
						continue;
					} else {
						break;
					}
				}
				// 两棵树的节点都为空
				else if (tree1Node == null && tree2Node == null) {
					continue;
				}
				// 其中一棵树节点为空
				else {
					break;
				}
			}

			// tree1的非空节点
			for (Integer node : tree1AllNodes){
				if (node != null){
					tree1NotNullCount++;
				}
			}
			// tree2的非空节点
			for (Integer node : tree2AllNodes){
				if (node != null){
					tree2NotNullCount++;
				}
			}

			// tree1和tree2和节点比较相同次数一样
			if (tree1NotNullCount == countTime && tree2NotNullCount == countTime){
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取所有节点数据
	 */
	private static List<Integer> getAllNodes(TreeNode node){
		// 前序遍历,递归获取所有节点信息
		ArrayList<Integer> treeNodes = new ArrayList<>();
		if(node != null){
			treeNodes.add(node.val);
			if (node.left != null){
				List<Integer> allLeftNodes = getAllNodes(node.left);
				treeNodes.addAll(allLeftNodes);
			} else if (node.right != null){
				treeNodes.add(null);
			}

			if (node.right != null){
				List<Integer> allRightNodes = getAllNodes(node.right);
				treeNodes.addAll(allRightNodes);
			}

		}
		return treeNodes;
	}

	/**
	 * 创建一棵树
	 */
    public static TreeNode getATree(){
		TreeNode headNode = new TreeNode(1);
		TreeNode leftNode = new TreeNode(2);
		TreeNode rightNode = new TreeNode(3);
		headNode.setLeft(leftNode);
		headNode.setRight(rightNode);
		return headNode;
	}
    public static TreeNode getATreeV2(){
		TreeNode headNode = new TreeNode(1);
		TreeNode leftNode = new TreeNode(2);
		TreeNode rightNode = new TreeNode(3);
		headNode.setLeft(leftNode);
		headNode.setRight(rightNode);
		return headNode;
	}

}

