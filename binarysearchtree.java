package Tree;

// Kelas untuk merepresentasikan node dalam BST
class Node {
    int data;
    Node left, right;

    // Konstruktor untuk membuat node dengan data tertentu
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Kelas untuk merepresentasikan Binary Search Tree (BST)
public class binarysearchtree {
    Node root;  // Node akar dari BST

    // Metode untuk menyisipkan node baru ke dalam BST
    public Node insert(Node root, int data) {
        // Jika sub-pohon kosong, ciptakan node baru sebagai akar dari sub-pohon
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Rekursif menambahkan node berdasarkan perbandingan data
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Metode untuk mencetak struktur pohon dalam bentuk folder
    public void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.println(indent + "+-- " + node.data);
            indent += last ? "    " : "|   ";
            printTree(node.right, indent, false);
            printTree(node.left, indent, true);
        }
    }

    public static void main(String[] args) {
        binarysearchtree bst = new binarysearchtree();  // Membuat objek BST

        // Membangun struktur BST sesuai contoh
        //        50
        //      /    \
        //     30     70
        //    /  \   /  \
        //   10  35 65   80
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        // Mencetak struktur pohon dalam bentuk folder
        bst.printTree(bst.root, "", true);
    }
}
