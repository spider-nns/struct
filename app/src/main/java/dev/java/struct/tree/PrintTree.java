package dev.java.struct.tree;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author spider
 * @date 2021/3/7
 */
public class PrintTree {
    public static void main(String[] args) {
        printTreeNode();
    }

    static void printTreeNode() {
        TreeNode rootNode = TreeNode.initTreeNodeWithCapacity();
        ArrayList<String> list = Lists.newArrayList();
        preOrderPrintTree(rootNode, list);
        System.out.println(list);
        list.clear();
        inOrderPrintTree(rootNode, list);
        System.out.println(list);
        list.clear();
        postOrderPrintTree(rootNode, list);
        System.out.println(list);
    }

    static void preOrderPrintTree(TreeNode node, List list) {
        if (node != null) {
            list.add(node.val);
            preOrderPrintTree(node.left, list);
            preOrderPrintTree(node.right, list);
        }
    }

    static void inOrderPrintTree(TreeNode node, List list) {
        if (node != null) {
            inOrderPrintTree(node.left, list);
            list.add(node.val);
            inOrderPrintTree(node.right, list);
        }
    }

    static void postOrderPrintTree(TreeNode node, List list) {
        if (node != null) {
            postOrderPrintTree(node.left, list);
            postOrderPrintTree(node.right, list);
            list.add(node.val);
        }
    }
}
