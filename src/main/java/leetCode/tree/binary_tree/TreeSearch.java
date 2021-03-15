package leetCode.tree.binary_tree;

/**
 * REMARK 二叉树测试
 *
 * @author: mmb
 * @date: 19-9-16
 */
public class TreeSearch {

	/**
	 * 构造树
	 */
	public TreeNode getTargetTree() {
		// 叶子节点
		TreeNode G = new TreeNode("G");
		TreeNode D = new TreeNode("D");
		TreeNode E = new TreeNode("E", G, null);
		TreeNode B = new TreeNode("B", D, E);
		TreeNode H = new TreeNode("H");
		TreeNode I = new TreeNode("I");
		TreeNode F = new TreeNode("F", H, I);
		TreeNode C = new TreeNode("C", null, F);
		// 构造根节点
		TreeNode root = new TreeNode("A", B, C);
		return root;
	}

	// 节点数据结构
	class TreeNode {

		private String value = null;
		private TreeNode leftchildren = null;
		private TreeNode rightchildre = null;

		public TreeNode(String value, TreeNode leftchildren, TreeNode rightchildre) {
			this.value = value;
			this.leftchildren = leftchildren;
			this.rightchildre = rightchildre;
		}

		public TreeNode(String value) {
			this.value = value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public void setLeftchildren(TreeNode leftchildren) {
			this.leftchildren = leftchildren;
		}

		public void setRightchildre(TreeNode rightchildre) {
			this.rightchildre = rightchildre;
		}

		public String getValue() {
			return value;
		}

		public TreeNode getLeftchildren() {
			return leftchildren;
		}

		public TreeNode getRightchildre() {
			return rightchildre;
		}
	}

	// 先序遍历二叉树
	public void preorderVistTreeNode(TreeNode node) {
		if (node != null) {
			System.out.println(node.value);
		}

		if (node.getLeftchildren() != null) {
			preorderVistTreeNode(node.getLeftchildren());
		}

		if (node.getRightchildre() != null) {
			preorderVistTreeNode(node.getRightchildre());
		}

	}


	public static void main(String[] args) {
		TreeSearch treeSearch = new TreeSearch();
		TreeNode tree = treeSearch.getTargetTree();
		treeSearch.preorderVistTreeNode(tree);
	}
}
