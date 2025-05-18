public class BinarySearchTree extends Tree {
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80, 35, 65};
        
        for (int value : values) {
            bst.insert(value);
        }
        
        bst.printPreOrder();  // 50 30 20 40 35 70 60 65 80
        bst.printInOrder();   // 20 30 35 40 50 60 65 70 80
        bst.printPostOrder(); // 20 35 40 30 65 60 80 70 50
    }
}
