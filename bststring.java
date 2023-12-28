package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Kelas untuk merepresentasikan node dalam pohon biner
class Node {
    String value;
    Node left;
    Node right;

    // Konstruktor untuk membuat node dengan nilai tertentu
    public Node(String value) {
        this.value = value;
        left = null;
        right = null;
    }
}

// Kelas untuk pohon pencarian biner dengan tipe data String
class bststring {
    Node root;

    // Konstruktor untuk membuat objek bststring
    public bststring() {
        root = null;
    }

    // Metode untuk menyisipkan node baru ke dalam BST
    public Node insert(Node root, String value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = insert(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Metode untuk traversal pre-order
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Metode untuk traversal in-order
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    // Metode untuk traversal post-order
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Metode untuk traversal level-order
    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Metode untuk mencetak struktur pohon dalam bentuk folder
    // Metode untuk mencetak struktur pohon dalam bentuk folder
public void printTree(Node node, String prefix, boolean isTail) {
    // Memeriksa apakah node tidak null
    if (node != null) {
        // Menampilkan garis dan tanda panah berdasarkan posisi node dalam pohon
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value);
        
        // Membuat list untuk menyimpan anak-anak dari node
        List<Node> children = new ArrayList<>();
        
        // Menambahkan anak kiri ke dalam list jika tidak null
        if (node.left != null) children.add(node.left);
        
        // Menambahkan anak kanan ke dalam list jika tidak null
        if (node.right != null) children.add(node.right);
        
        // Iterasi melalui anak-anak untuk mencetak struktur pohon
        for (int i = 0; i < children.size() - 1; i++) {
            // Memanggil rekursif untuk anak-anak dengan prefix yang sesuai
            printTree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
        }
        
        // Memanggil rekursif untuk anak terakhir dengan prefix yang sesuai
        if (children.size() > 0) {
            printTree(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
        }
    }
}


    // Metode utama
    public static void main(String[] args) {
        bststring tree = new bststring();  // Membuat objek pohon biner
        tree.root = tree.insert(tree.root, "Mango");
        tree.insert(tree.root, "Apple");
        tree.insert(tree.root, "Orange");
        tree.insert(tree.root, "Banana");
        tree.insert(tree.root, "Grapes");
        tree.insert(tree.root, "Pineapple");
        tree.insert(tree.root, "Peach");

        System.out.println("Struktur pohon biner:");
        tree.printTree(tree.root, "", true);

        System.out.println("Traversal pre-order:");
        tree.preorder(tree.root);

        System.out.println("\nTraversal in-order:");
        tree.inorder(tree.root);

        System.out.println("\nTraversal post-order:");
        tree.postorder(tree.root);

        System.out.println("\nTraversal level-order:");
        tree.levelOrder(tree.root);
    }
}
