public class tugas_4 {
    // Node class for BST
    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    public tugas_4() {
        root = null;
    }

    // Method to insert a new key in BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    private Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the unchanged node pointer
        return root;
    }

    // Method to track the path of searching a key in BST
    public String track(int key) {
        // Start with the root node
        Node current = root;
        // Initialize the result string
        String result = "";
        
        // Check if tree is empty
        if (current == null) {
            return "Tree is empty";
        }
        
        // Add the root value to the result
        result += current.key;
        
        // Traverse the tree
        while (current != null && current.key != key) {
            if (key < current.key) {
                // Check if left child exists
                if (current.left == null) {
                    result += " kiri null";
                    current = null; // Exit the loop
                    break;
                } else {
                    result += " kiri " + current.left.key;
                    current = current.left;
                }
            } else {
                // Check if right child exists
                if (current.right == null) {
                    result += " kanan null";
                    current = null; // Exit the loop
                    break;
                } else {
                    result += " kanan " + current.right.key;
                    current = current.right;
                }
            }
        }
        
        // Add the result message
        if (current != null && current.key == key) {
            result += ". Key ditemukan";
        } else {
            result += ". Key tidak ditemukan";
        }
        
        return result;
    }

    public static void main(String[] args) {
        tugas_4 tree = new tugas_4();
        
        tree.insert(6);
        tree.insert(3);
        tree.insert(47);
        tree.insert(23);
        tree.insert(7);
        tree.insert(25);
        tree.insert(39);
        tree.insert(67);
        tree.insert(66);
        tree.insert(75);
        

        System.out.println("track(39) : " + tree.track(39));
        System.out.println("track(60) : " + tree.track(60));
    }
}