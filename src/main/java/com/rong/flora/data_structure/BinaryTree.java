package com.rong.flora.data_structure;



/**
 * Created by rongwf1 on 2016/12/23.
 */
public class BinaryTree <T extends Number>{
    TreeNode<T> root;
   public BinaryTree(){
       root = null;
   }
   public BinaryTree(T value){
       root = new TreeNode<>(value);
   }

    public void add(TreeNode<T> root, T value){
        TreeNode<T> node = new TreeNode<>(value);
        if (root == null){
            root = node;
        } else {
            if (node.compareTo(root) <= 0){
                add(root.left, value);
            } else {
                add(root.right, value);
            }
        }
    }


   public static class TreeNode<T extends Number> implements Comparable<TreeNode> {
        TreeNode<T> parent;
        TreeNode<T> left;
        TreeNode<T> right;
        T value;

        public TreeNode(T value){
            parent = null;
            left = null;
            right = null;
            this.value = value;
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
        public int compareTo(TreeNode o) {
            return this.value.intValue() - o.value.intValue();
        }
    }

    public static void main(String... args){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(null, 100);
    }
}
