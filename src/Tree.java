public abstract class Tree {
    protected Node root;
    
    public Tree() {
        root = null;
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    public void printPreOrder() {
        System.out.println("PreOrder:");
        preOrder(root);
        System.out.println();
    }
    
    public void printInOrder() {
        System.out.println("InOrder:");
        inOrder(root);
        System.out.println();
    }
    
    public void printPostOrder() {
        System.out.println("PostOrder:");
        postOrder(root);
        System.out.println();
    }
}