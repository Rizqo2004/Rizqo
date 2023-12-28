package Tree;

// Kelas untuk merepresentasikan node dalam pohon biner
class Node {
    int data;  // Data yang disimpan dalam node
    Node left, right;  // Anak kiri dan anak kanan dari node

    // Konstruktor untuk membuat node dengan data tertentu
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Kelas untuk merepresentasikan pohon biner
public class binarytree {
    Node root;  // Akar dari pohon biner

    public static void main(String[] args) {
        binarytree tree = new binarytree();  // Membuat objek pohon biner

        // Membuat nodes
        tree.root = new Node(1);
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.right.left = new Node(9);
        tree.root.right.left.left = new Node(10);

        // Print tree untuk verifikasi
        printTree(tree.root, "", true);
    }

    // Metode untuk mencetak struktur pohon dalam bentuk folder
    public static void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.println(indent + "+-- " + node.data);  // Mencetak data node
            indent += last ? "    " : "|   ";  // Menyesuaikan indentasi
            printTree(node.right, indent, false);  // Mencetak anak kanan
            printTree(node.left, indent, true);  // Mencetak anak kiri
        }
    }
}
