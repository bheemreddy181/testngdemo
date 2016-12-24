package com.rong.flora.data_structure;



/**
 * Created by rongwf1 on 2016/12/23.
 */
public class BinarySearchTree<T extends Number>{
    TreeNode<T> root;
   public BinarySearchTree(){
       root = null;
   }
   public BinarySearchTree(T value){
       root = new TreeNode<>(value, "");
   }


    public void add(TreeNode<T> root, T value, String msg){
        TreeNode<T> node = new TreeNode<>(value, msg);
        if (this.root == null) {
            this.root = node;
            return;
        }

        if (node.compareTo(root) <= 0) {
            if (root.left == null) {
                root.left = node;
                node.parent = root;
            } else {
                add(root.left, value, msg);
            }
        } else {
            if (root.right == null) {
                root.right = node;
                node.parent = root;
            } else {
                add(root.right, value, msg);
            }
        }
    }

    public TreeNode<T> iterativeTreeSearch(TreeNode<T> root, T value){
        while (root != null && !value.equals(root.value)){
            if (value.intValue() < root.value.intValue()){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    public TreeNode<T> minimum(TreeNode<T> root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public TreeNode<T> maximum(TreeNode<T> root){
        while (root.right != null){
            root = root.right;
        }
        return root;
    }

    public TreeNode<T> successor(TreeNode<T> node){
        if (node.right != null){
            return minimum(node.right);
        }
        TreeNode<T> parent = node.parent;
        while (parent != null && node.equals(parent.right)){
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public TreeNode<T> predecessor(TreeNode<T> node){
        if (node.left != null){
            return maximum(node.left);
        }
        TreeNode<T> parent = node.parent;
        while (parent != null && node.equals(parent.left)){
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public void preorderWalk(TreeNode<T> node){
        if (node != null){
            if (node.left != null){
                preorderWalk(node.left);
            }
            System.out.println(node);
            if (node.right != null){
                preorderWalk(node.right);
            }
        }
    }

    public void postWalk(TreeNode<T> node){
        if (node != null){
            if (node.right != null){
                postWalk(node.right);
            }
            System.out.println(node);
            if (node.left != null){
                postWalk(node.left);
            }
        }
    }

    public TreeNode<T> delete(TreeNode<T> node){
        TreeNode<T> realDelete;
        TreeNode<T> childOfRealDelete;
        //step1: find the node to delete really
        // If the node has two children, the really deleted node is node's successor
        // If the node has one child or has no child, the really deleted node is node self
        if (node.left == null || node.right == null){
            realDelete = node;
        }else {
            realDelete = successor(node);
        }

        // step2  find the child node of really deleted node
        if (realDelete.left != null){
            childOfRealDelete = realDelete.left;
        } else {
            childOfRealDelete = realDelete.right;
        }
        // step 3 reset the relation
        // 1. Set really deleted node's parent's child to childOfRealDelete
        // 2. Set parent node of childOfRealDelete to the parent of realDelete
        // 2.1 If the node to delete is root node, then childOfRealDelete becomes new root
        if (childOfRealDelete != null){
            childOfRealDelete.parent = realDelete.parent;
        }
        if (realDelete.parent == null){
            root = childOfRealDelete;
        } else {
            if (realDelete == realDelete.parent.left){
                realDelete.parent.left = childOfRealDelete;
            } else {
                realDelete.parent.right = childOfRealDelete;
            }
        }

        //step4 if the really deleted node is node's successor, copy the value of successor to node
        // It is actually swap node and node's successor, then delete node.
        if (realDelete != node){
            T tmp = node.value;
            node.value = realDelete.value;
            realDelete.value = tmp;
        }
        return realDelete;
    }


   public static class TreeNode<T extends Number> implements Comparable<TreeNode> {
        TreeNode<T> parent;
        TreeNode<T> left;
        TreeNode<T> right;
        T value;
        String msg;

        public TreeNode(T value, String msg){
            parent = null;
            left = null;
            right = null;
            this.value = value;
            this.msg = msg;
        }

        public TreeNode<T> getParent() {
            return parent;
        }

        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

       @Override
       public String toString() {
           return "TreeNode{" +
                   "value=" + value +
                   '}';
       }

       @Override
        public int compareTo(TreeNode o) {
            return this.value.intValue() - o.value.intValue();
        }
    }

    public static void main(String... args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(tree.root, 15, "15");
        tree.add(tree.root, 5, "5");
        tree.add(tree.root, 3, "3");
        tree.add(tree.root, 12, "12");
        tree.add(tree.root, 10, "10");
        tree.add(tree.root, 6, "6");
        tree.add(tree.root, 7, "7");
        tree.add(tree.root, 13, "13");
        tree.add(tree.root, 16, "16");
        tree.add(tree.root, 20, "20");
        tree.add(tree.root, 18, "18");
        tree.add(tree.root, 23, "23");
        System.out.println(tree.root);
        System.out.println(tree.iterativeTreeSearch(tree.root,10));
        System.out.println(tree.iterativeTreeSearch(tree.root,20));
        System.out.println(tree.minimum(tree.root));
        System.out.println(tree.maximum(tree.root));

        System.out.println(tree.successor(tree.iterativeTreeSearch(tree.root, 13)));
        System.out.println(tree.successor(tree.iterativeTreeSearch(tree.root, 5)));
        System.out.println(tree.successor(tree.iterativeTreeSearch(tree.root, 7)));

        System.out.println(tree.predecessor(tree.iterativeTreeSearch(tree.root, 3)));
        System.out.println(tree.predecessor(tree.iterativeTreeSearch(tree.root, 5)));
        System.out.println(tree.predecessor(tree.iterativeTreeSearch(tree.root, 7)));
        tree.preorderWalk(tree.root);
        tree.postWalk(tree.root);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(tree.delete(tree.iterativeTreeSearch(tree.root, 16)));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(tree.iterativeTreeSearch(tree.root, 15).right);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        tree.preorderWalk(tree.root);

    }
}
