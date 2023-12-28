package Graph;

import java.util.*;

// Deklarasi kelas untuk graf
class Graph {
    // Mendeklarasikan variabel adjacencyList untuk menyimpan informasi tetangga setiap node
    private Map<Integer, List<Integer>> adjacencyList;

    // Konstruktor kelas untuk inisialisasi objek graf
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Method untuk menambahkan node baru ke dalam graf
    public void addNode(Integer node) {
        // Menambahkan node ke adjacencyList jika belum ada
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Method untuk menambahkan edge (sambungan) dari suatu node ke node lain dalam graf
    public void addEdge(int source, int destination) {
        // Menambahkan edge dari node sumber ke node tujuan
        adjacencyList.get(source).add(destination);
    }

    // Method untuk mendapatkan daftar tetangga dari suatu node dalam graf
    public List<Integer> getNeighbors(int node) {
        // Mengembalikan daftar tetangga dari node jika node tersebut ada dalam graf, jika tidak kembalikan daftar kosong
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Method untuk mencetak informasi graf (node dan tetangganya)
    public void printGraph() {
        // Iterasi melalui setiap node dalam graf
        for (int node : adjacencyList.keySet()) {
            // Mencetak informasi node dan tetangganya
            System.out.print("Node " + node + " terhubung dengan: ");
            for (int neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Method utama untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek dari kelas Graph
        Graph graph = new Graph();

        // Menambahkan beberapa node ke dalam graf
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        // Menambahkan beberapa edge ke dalam graf (kasus kedua)
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        // Mencetak informasi graf setelah diinisialisasi
        graph.printGraph();
    }
}
