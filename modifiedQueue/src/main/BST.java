package main;


public class BST {

    private TreeNode root;

    public BST(){super();}

    public boolean isEmpty(){return root == null;}
    public TreeIterator find(int n){
        return find(n, root); //returns null if not found, and a new treeiterator if found
    }
    public TreeIterator find(int n, TreeNode t){
        if(n == t.getData()) return new TreeIterator(t);
        if(n < t.getData()){
            if(t.getLeft() == null) return null;
            else return find(n, t.getLeft());
        }
        else{
            if(t.getRight() == null) return null;
            else return find(n, t.getRight());
        }
    }
    public void delete(int n){
        TreeIterator found = find(n); //null if not found
        if(found == null) return;
        if(found.isLeaf()){
            if(found.isRoot())found = null;
            else {
                TreeNode p = found.me.getParent();
                if(n < p.getData()) p.setLeft(null);
                else p.setRight(null);
            }
        }
    }
    public void insert(int n) { //helper method
        if(isEmpty()) root = new TreeNode(n);
        else{
            insert(n, this.root);
        }
    }
    private void insert(int n, TreeNode t){
        if(n < t.getData()){
            if(t.hasLeft()) insert(n, t.getLeft());
            else t.setLeft(new TreeNode(n));
        }
        else{
            if(t.hasRight()) insert(n, t.getRight());
            else t.setRight(new TreeNode(n));

        }
    }
    public String toString(){
        String temp = "My tree, read from L to R... \n";
        if(! isEmpty())temp += LRoutput(root);//helper method
        return temp;
    }
    public String LRoutput(TreeNode t){
        String temp = "";
        if(t.hasLeft()) temp += LRoutput(t.getLeft());
        temp += t.getData() + ", ";
        if(t.hasRight()) temp += LRoutput(t.getRight());
        return temp;
    }

    public class TreeIterator {
        private TreeNode me;

        public TreeIterator(TreeNode t){this.me = t;}

        public int getData(){
            if(me != null) return me.getData();
            return -911;
        }
        public void goLeft(){if(me != null) me = me.getLeft();}
        public void goRight(){if(me != null) me = me.getRight();}
        public void goUp(){if(me != null && me != root) me = me.getParent();}
        public boolean hasLeft(){return me.hasLeft();}
        public boolean hasRight(){return me.hasRight();}
        public boolean isLeaf(){return !hasLeft() && !hasRight();}
        public int numChildren(){
            if(isLeaf()) return 0;
            if(hasLeft() && hasRight()) return 2;
            return 1;
        }
        public boolean isRoot(){return me == root;}
    }


}
