package leetCode.tree.binary_tree;

/**
 * <p>
 *     二叉查找树：查找、新增、删除节点。是过度到自平衡二叉树和红黑树的基础。
 * </p>
 */

public class SearchBST {

	BiTNode searchBST(BiTNode T, int key, BiTNode left, BiTNode right){
		if (T != null){

		}
		return null;
	}

}
class BiTNode{
	private int data;
	private BiTNode leftChild;
	private BiTNode rightChild;

	public int getData() {
		return this.data;
	}

	public void setData(final int data) {
		this.data = data;
	}

	public BiTNode getLeftChild() {
		return this.leftChild;
	}

	public void setLeftChild(final BiTNode leftChild) {
		this.leftChild = leftChild;
	}

	public BiTNode getRightChild() {
		return this.rightChild;
	}

	public void setRightChild(final BiTNode rightChild) {
		this.rightChild = rightChild;
	}
}
