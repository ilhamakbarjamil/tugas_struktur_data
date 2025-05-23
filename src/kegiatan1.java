import java.util.Scanner;

class NodeKeluarga {
    String nama;
    String jenisKelamin;
    String relasi;
    NodeKeluarga left;
    NodeKeluarga right;

    public NodeKeluarga(String nama, String jenisKelamin, String relasi) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.relasi = relasi;
        this.left = null;
        this.right = null;
    }
}

class KeluargaTree {
    NodeKeluarga root;
    Scanner scanner = new Scanner(System.in);

    public void tambahAnggota() {
        System.out.print("Masukkan jumlah anggota keluarga (min 5): ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); 

        if (jumlah < 5) {
            System.out.println("Minimal 5 anggota!");
            return;
        }

        System.out.println("\n** Masukkan Kepala Keluarga **");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        root = new NodeKeluarga(nama, "-", "Kepala Keluarga");

        for (int i = 1; i < jumlah; i++) {
            System.out.println("\n** Anggota ke-" + (i + 1) + " **");
            System.out.print("Nama: ");
            nama = scanner.nextLine();
            System.out.print("Jenis Kelamin (Pria/Wanita): ");
            String jk = scanner.nextLine();
            System.out.print("Relasi (Contoh: 'Anak 1 dari Ayah'): ");
            String relasi = scanner.nextLine();

            tambahNode(root, nama, jk, relasi);
        }
    }

    private void tambahNode(NodeKeluarga current, String nama, String jk, String relasi) {
        System.out.print("Posisi (kiri/kanan) dari '" + current.nama + "': ");
        String posisi = scanner.nextLine();

        if (posisi.equalsIgnoreCase("kiri")) {
            if (current.left == null) {
                current.left = new NodeKeluarga(nama, jk, relasi);
            } else {
                tambahNode(current.left, nama, jk, relasi);
            }
        } else if (posisi.equalsIgnoreCase("kanan")) {
            if (current.right == null) {
                current.right = new NodeKeluarga(nama, jk, relasi);
            } else {
                tambahNode(current.right, nama, jk, relasi);
            }
        }
    }

    public void visualisasiTree(NodeKeluarga node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.nama + " (" + node.relasi + ")");
        visualisasiTree(node.left, indent + "├── ");
        visualisasiTree(node.right, indent + "└── ");
    }

    public void preOrder(NodeKeluarga node) {
        if (node == null) return;
        System.out.print("[" + node.nama + "] ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(NodeKeluarga node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print("[" + node.nama + "] ");
        inOrder(node.right);
    }

    public void postOrder(NodeKeluarga node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print("[" + node.nama + "] ");
    }

    public static void main(String[] args) {
        KeluargaTree tree = new KeluargaTree();
        tree.tambahAnggota();

        System.out.println("\nVisualisasi Pohon Keluarga:");
        tree.visualisasiTree(tree.root, "");

        System.out.println("\nPreOrder Traversal:");
        tree.preOrder(tree.root);

        System.out.println("\n\nInOrder Traversal:");
        tree.inOrder(tree.root);

        System.out.println("\n\nPostOrder Traversal:");
        tree.postOrder(tree.root);
    }
}