package dev.java.struct.tree;

/**
 * @author spider
 * @date 2021/3/7
 */
public class TreeNode {
    Object val;
    TreeNode left, right;

    //高度 节点到叶子节点的最长路径
    //深度 根节点到这个节点所经历边的个数
    //层数 节点的深度 + 1
    //高度 根节点的高度

    public TreeNode(Object val) {
        this.val = val;
    }

    public TreeNode() {
    }

    //二叉树,每个节点最多有两个子节点
    //满二叉树,除了叶子节点，每个节点都有左右两个子节点
    //完全二叉树,除了最后一层,其他层节点个数都达到最大，最后一层叶子节点靠左排列
    //完全二叉树使用数组存储最节省内存

    static TreeNode initTreeNodeWithCapacity() {
        TreeNode rootNode = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        rootNode.left = b;
        rootNode.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        return rootNode;
    }
}
