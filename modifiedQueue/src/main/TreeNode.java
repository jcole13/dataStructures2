package main;


public class TreeNode {
    private People data; //running out of time
    private TreeNode left, right, parent;


    public TreeNode(People i){
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
    public People getData() {
        return data;
    }
    public void setData(People data) {
        this.data = data;
    }
    public boolean hasLeft(){return this.left != null;}
    public boolean hasRight(){return this.right != null;}
    public boolean isRoot(){return parent == null;}



}
