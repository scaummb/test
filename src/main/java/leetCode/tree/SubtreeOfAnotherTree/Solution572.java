package leetCode.tree.SubtreeOfAnotherTree;

import leetCode.tree.TreeNode;

/**
 * REMARK 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 递归解决
 *
 * 一个树是另一个树的子树 则
 *   1.要么这两个树相等
 *   2.要么这个树是左树的子树
 *   3.要么这个树是右树的子树
 *
 * @author: mmb
 * @date: 20-1-27
 */
public class Solution572 {

    public static boolean isSubtree(TreeNode s, TreeNode t) {
       if (t == null && s == null){
           return true;
       }

       return (s.equals(t))
               && (Integer.compare(s.getVal(), t.getVal()) == 0)
               && isSameTree(s.getLeft(), t.getLeft())
               && isSameTree(s.getRight(), t.getRight())
               ;
    }

    private static boolean isSameTree(TreeNode s, TreeNode t) {
        if (t == null && s == null){
            return true;
        }

        if (s == null && t != null){
            return false;
        }

        return isSameTree(s, t)
                || isSubtree(s.getLeft(), t)
                || isSubtree(s.getRight(), t);
    }

    public static void main(String[] args) {
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode13 = new TreeNode(3);
        TreeNode treeNode14 = new TreeNode(4);
        TreeNode treeNode15 = new TreeNode(5);
        treeNode14.setLeft(treeNode11);
        treeNode14.setRight(treeNode12);
        treeNode13.setLeft(treeNode14);
        treeNode13.setRight(treeNode15);

        TreeNode treeNode21 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode23 = new TreeNode(4);
        treeNode23.setLeft(treeNode21);
        treeNode23.setRight(treeNode22);

        System.out.println(treeNode13);
        System.out.println(treeNode23);
        System.out.println(isSubtree(treeNode13, treeNode23));

    }
}
