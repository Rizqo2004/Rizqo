package Graph;


import java.util.*;

// Kelas undirectedgraph untuk merepresentasikan graf tidak terarah dengan node dan sisi bertipe String.
class undirectedgraph {
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk inisialisasi objek undirectedgraph
    public undirectedgraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan edge atau sisi ke dalam graf (di kedua arah untuk graf tidak terarah)
    public void addEdge(String source, String destination) {
        // Pastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan dan sebaliknya
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Metode untuk mendapatkan daftar tetangga dari suatu node
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Metode untuk mencetak graf
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Metode main untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek dari kelas UndirectedGraph
        undirectedgraph graph = new undirectedgraph();

        // Menambahkan node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge atau sisi ke graf
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        // Mencetak graf
        graph.printGraph();
    }
}
