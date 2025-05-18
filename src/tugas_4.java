public class tugas_4 {
    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    Node root;

    public tugas_4() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public String track(int key) {
        Node current = root;
        String result = "";
        
        if (current == null) {
            return "Tree is empty";
        }
        
        
        result += current.key;
        while (current != null && current.key != key) {
            if (key < current.key) {
                
                if (current.left == null) {
                    result += " kiri null";
                    current = null; 
                    break;
                } else {
                    result += " kiri " + current.left.key;
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    result += " kanan null";
                    current = null; 
                    break;
                } else {
                    result += " kanan " + current.right.key;
                    current = current.right;
                }
            }
        }

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