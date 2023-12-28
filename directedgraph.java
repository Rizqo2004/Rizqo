package Graph;


import java.util.*;

// Deklarasi kelas untuk graf berarah
class DirectedGraph {
    // Mendeklarasikan variabel adjacencyList untuk menyimpan informasi tetangga setiap node
    private Map<String, List<String>> adjacencyList;

    // Konstruktor kelas untuk inisialisasi objek graf
    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Method untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        // Menambahkan node ke adjacencyList jika belum ada
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Method untuk menambahkan edge (sambungan) dari suatu node ke node lain dalam graf
    public void addEdge(String source, String destination) {
        // Memastikan node sumber ada dalam adjacencyList
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Menambahkan edge dari node sumber ke node tujuan
        adjacencyList.get(source).add(destination);
    }

    // Method untuk mendapatkan daftar tetangga dari suatu node dalam graf
    public List<String> getNeighbors(String node) {
        // Mengembalikan daftar tetangga dari node jika node tersebut ada dalam graf, jika tidak kembalikan daftar kosong
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Method untuk mencetak informasi graf (node dan tetangganya)
    public void printGraph() {
        // Iterasi melalui setiap node dalam graf
        for (String node : adjacencyList.keySet()) {
            // Mencetak informasi node dan tetangganya
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Method utama untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek dari kelas DirectedGraph
        DirectedGraph graph = new DirectedGraph();

        // Menambahkan beberapa node ke dalam graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan beberapa edge ke dalam graf (kasus pertama)
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        // Mencetak informasi graf setelah diinisialisasi
        graph.printGraph();
    }
}
