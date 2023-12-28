package Tree;
// Mengimpor kelas-kelas Java yang diperlukan
import java.util.LinkedList;
import java.util.Queue;

// Definisi Node dalam pohon biner
class Node {
    int data;
    Node left, right;

    // Konstruktor untuk menginisialisasi sebuah node dengan data yang diberikan
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Definisi kelas traversal Pohon Pencarian Biner (BST)
public class bsttraversal {

    // Akar dari Pohon Pencarian Biner
    Node root;

    // Metode untuk menyisipkan node baru dengan data yang diberikan ke dalam BST
    public Node insert(Node root, int data) {
        // Jika pohon kosong, buat node baru sebagai akar
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Jika data lebih kecil dari data akar, pergi ke subpohon kiri
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        // Jika data lebih besar dari data akar, pergi ke subpohon kanan
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Metode untuk traversal in-order dari BST
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // Metode untuk traversal post-order dari BST
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Metode untuk traversal level-order dari BST
    public void levelOrder(Node root) {
        if (root == null) return;

        // Menggunakan antrian untuk traversal level-order
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Memproses node saat ini
            Node current = queue.poll();
            System.out.print(current.data + " ");

            // Menambahkan anak kiri ke antrian jika ada
            if (current.left != null) queue.add(current.left);
            // Menambahkan anak kanan ke antrian jika ada
            if (current.right != null) queue.add(current.right);
        }
    }

    // Metode utama untuk menguji traversal BST
    public static void main(String[] args) {
        // Membuat instansi dari kelas traversal BST
        bsttraversal bst = new bsttraversal();
        
        // Membuat struktur BST
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        // Melakukan traversal in-order dan mencetak hasilnya
        System.out.println("In-Order traversal:");
        bst.inOrder(bst.root);
        System.out.println();

        // Melakukan traversal post-order dan mencetak hasilnya
        System.out.println("Post-Order traversal:");
        bst.postOrder(bst.root);
        System.out.println();

        // Melakukan traversal level-order dan mencetak hasilnya
        System.out.println("Level-Order traversal:");
        bst.levelOrder(bst.root);
        System.out.println();
    }
}
