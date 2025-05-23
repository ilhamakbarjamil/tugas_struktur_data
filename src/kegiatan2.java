import java.util.Scanner;

class NodeFilm {
    String kodeProduksi;
    String judul;
    String genre;
    int tahunRilis;
    String rating;
    int jumlahCopy;
    NodeFilm left, right;

    public NodeFilm(String kode, String judul, String genre, int tahun, String rating, int copy) {
        kodeProduksi = kode;
        this.judul = judul;
        this.genre = genre;
        tahunRilis = tahun;
        this.rating = rating;
        jumlahCopy = copy;
        left = right = null;
    }
}

class BSTFilm {
    NodeFilm root;
    Scanner scanner = new Scanner(System.in);

    public void insertFilm() {
        System.out.print("Kode Produksi: ");
        String kode = scanner.nextLine();
        System.out.print("Judul Film: ");
        String judul = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Tahun Rilis: ");
        int tahun = Integer.parseInt(scanner.nextLine());
        System.out.print("Rating Usia: ");
        String rating = scanner.nextLine();
        System.out.print("Jumlah Copy: ");
        int copy = Integer.parseInt(scanner.nextLine());

        root = insert(root, new NodeFilm(kode, judul, genre, tahun, rating, copy));
        System.out.println("Film berhasil ditambahkan!");
    }

    private NodeFilm insert(NodeFilm root, NodeFilm newNode) {
        if (root == null) return newNode;

        if (newNode.kodeProduksi.compareTo(root.kodeProduksi) < 0) {
            root.left = insert(root.left, newNode);
        } else {
            root.right = insert(root.right, newNode);
        }
        return root;
    }

    public void searchFilm() {
        System.out.print("Masukkan Kode Produksi: ");
        String kode = scanner.nextLine();
        NodeFilm result = search(root, kode);

        if (result == null) {
            System.out.println("Film tidak ditemukan!");
        } else {
            System.out.println("\nKode Produksi: " + result.kodeProduksi);
            System.out.println("Judul: " + result.judul);
            System.out.println("Genre: " + result.genre);
            System.out.println("Tahun Rilis: " + result.tahunRilis);
            System.out.println("Rating: " + result.rating);
            System.out.println("Jumlah Copy: " + result.jumlahCopy);
        }
    }

    private NodeFilm search(NodeFilm root, String kode) {
        if (root == null || root.kodeProduksi.equals(kode)) return root;

        if (kode.compareTo(root.kodeProduksi) < 0) {
            return search(root.left, kode);
        } else {
            return search(root.right, kode);
        }
    }

    public void inOrder(NodeFilm node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println("- " + node.judul + " (" + node.kodeProduksi + ")");
        inOrder(node.right);
    }

    public void preOrder(NodeFilm node) {
        if (node == null) return;
        System.out.println("- " + node.judul + " (" + node.kodeProduksi + ")");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(NodeFilm node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println("- " + node.judul + " (" + node.kodeProduksi + ")");
    }

    public void updateCopy() {
        System.out.print("Masukkan Kode Produksi: ");
        String kode = scanner.nextLine();
        NodeFilm film = search(root, kode);

        if (film == null) {
            System.out.println("Film tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan Jumlah Copy Baru: ");
        film.jumlahCopy = Integer.parseInt(scanner.nextLine());
        System.out.println("Update berhasil!");
    }

    public void tampilkanMenu() {
        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Film");
            System.out.println("2. Cari Film");
            System.out.println("3. Tampilkan Koleksi (InOrder)");
            System.out.println("4. Tampilkan Koleksi (PreOrder)");
            System.out.println("5. Tampilkan Koleksi (PostOrder)");
            System.out.println("6. Update Jumlah Copy");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1 -> insertFilm();
                case 2 -> searchFilm();
                case 3 -> {
                    System.out.println("\nInOrder Traversal:");
                    inOrder(root);
                }
                case 4 -> {
                    System.out.println("\nPreOrder Traversal:");
                    preOrder(root);
                }
                case 5 -> {
                    System.out.println("\nPostOrder Traversal:");
                    postOrder(root);
                }
                case 6 -> updateCopy();
                case 7 -> System.out.println("Keluar...");
                default -> System.out.println("Input tidak valid!");
            }
        } while (pilihan != 7);
    }

    public static void main(String[] args) {
        BSTFilm sistem = new BSTFilm();
        sistem.tampilkanMenu();
    }
}