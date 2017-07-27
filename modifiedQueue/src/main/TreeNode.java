package main;


public class TreeNode {
    private Object data;
    private TreeNode left, right, parent;


    public TreeNode(Object i){
        left = null;
        right = null;
        parent = null;
        data = i;
    }

    public TreeNode getParent() {
        return parent;
    }
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
    public TreeNode getLeft() {
        return left;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getRight() {
        return right;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
    public Object getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public boolean hasLeft(){return this.left != null;}
    public boolean hasRight(){return this.right != null;}



}
