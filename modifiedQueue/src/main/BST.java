package main;


public class BST {

    private TreeNode root;

    public BST(){super();}

    public boolean isEmpty(){return root == null;}

    public TreeIterator find(String p){
        return find(p, root); //returns null if not found, and a new treeiterator if found
    }
    public TreeIterator find(String p, TreeNode t){
        //System.out.println("Got here");
        if(p.toLowerCase().compareTo(t.getData().getName().toLowerCase()) == 0){
            //System.out.println("terminate");
            //System.out.println()
            return new TreeIterator(t);
        }
        if(p.compareTo(t.getData().getName()) < 0){
            if(t.getLeft() == null) return null;
            else return find(p, t.getLeft());
        }
        else{
            if(t.getRight() == null) return null;
            else return find(p, t.getRight());
        }
    }
    public void delete(String s){
        TreeIterator found = find(s); //null if not found
        System.out.println("After find");
        if(found == null) return;
        if(found.isLeaf()){
            System.out.println("1");
            if(found.isRoot())found.me = null;
            else {
                TreeNode p = found.me.getParent();
                System.out.println("P: " + p);
                //System.out.println(p.getData().getName());
                if(s.compareTo(p.getData().getName()) < 0) p.setLeft(null);
                else p.setRight(null);
            }
        } else if(found.numChildren() == 1){

            TreeNode p = null;
            if(!found.isRoot()) p = found.me.getParent();
            System.out.println("2");
            //if(p.isRoot())
            //System.out.println(p.hasLeft());
            if(p != null) {
                if (p.hasLeft()) {
                    if (found.me.hasLeft()) {
                        p.setLeft(found.me.getLeft());
                    } else {
                        p.setLeft(found.me.getRight());
                    }
                } else {
                    if (found.me.hasLeft()) {
                        p.setRight(found.me.getLeft());
                    } else {
                        p.setLeft(found.me.getRight());
                    }
                }
            }
            else{
                if(found.hasLeft()) root = found.me.getLeft();
                else root = found.me.getRight();
            }

        }
        else{
            TreeNode deletee = found.me;
            TreeNode firstLeft = deletee.getLeft();
            System.out.println("3");
            boolean foundit = false;
            while(!foundit && firstLeft != null){
                if(firstLeft.hasRight()) firstLeft = firstLeft.getRight();
                else foundit = true;
            }
            TreeNode temp = firstLeft;
            firstLeft.setData(null);
            found.me.setData(temp.getData());
        }

    }
    public void insert(People p){//helper method
        //System.out.println("Here" + p);
        if(isEmpty()) root = new TreeNode(p);
        else{
            insert(p, this.root);
        }
    }
    private void insert(People p, TreeNode t){
        //System.out.println(p.getName());
        if(p.getName().compareTo(t.getData().getName()) < 0){
            if(t.hasLeft()) insert(p, t.getLeft());
            else t.setLeft(new TreeNode(p));
        }
        else{
            if(t.hasRight()) insert(p, t.getRight());
            else t.setRight(new TreeNode(p));

        }
    }
    public String toString(){
        String temp = "My tree, read from L to R... \n";
        if(! isEmpty())temp += LRoutput(root);//helper method
        return temp;
    }
    public String LRoutput(TreeNode t){ //helper
        String temp = "";
        if(t.hasLeft()) temp += LRoutput(t.getLeft());
        temp += t.getData() + ", ";
        if(t.hasRight()) temp += LRoutput(t.getRight());
        return temp;
    }

    public class TreeIterator {
        private TreeNode me;

        public TreeIterator(TreeNode t){this.me = t;}

        public People getData(){
            return me.getData();
        }
        public void goLeft(){if(me != null) me = me.getLeft();}
        public void goRight(){if(me != null) me = me.getRight();}
        public void goUp(){if(me != null && me != root) me = me.getParent();}
        public void setData(People p){ me.setData(p);}
        public boolean hasLeft(){return me.hasLeft();}
        public boolean hasRight(){return me.hasRight();}
        public boolean isLeaf(){return !hasLeft() && !hasRight();}
        public int numChildren(){
            if(isLeaf()) return 0;
            if(hasLeft() && hasRight()) return 2;
            return 1;
        }
        public boolean isRoot(){return me == root;}
        public String toString(){
            return "" + me.getData();
        }
    }


}
