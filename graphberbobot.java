package Graph;

import java.util.*;

// Mendefinisikan kelas Edge untuk merepresentasikan edge berbobot
class Edge {
    String destination; // Node tujuan dari edge
    int weight; // Bobot (weight) dari edge

    // Konstruktor untuk membuat objek Edge dengan node tujuan dan bobot
    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Mendefinisikan kelas graph berbobot untuk merepresentasikan graf berbobot
class WeightedGraph {
    private Map<String, List<Edge>> adjacencyList; // Struktur data untuk menyimpan adjacency list dengan edge berbobot

    // Konstruktor untuk inisialisasi objek graf berbobot
    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Method untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Method untuk menambahkan edge berbobot ke dalam graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot ke node sumber
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Method untuk mencetak informasi graf berbobot
    public void printGraph() {
        // Iterasi melalui setiap node dalam graf
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            
            // Iterasi melalui setiap edge berbobot dari node
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            
            System.out.println();
        }
    }

    // Method utama untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek dari kelas WeightedGraph
        WeightedGraph graph = new WeightedGraph();

        // Menambahkan beberapa node ke dalam graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan beberapa edge berbobot ke dalam graf (kasus ketiga)
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // Mencetak informasi graf berbobot setelah diinisialisasi
        graph.printGraph();
    }
}
