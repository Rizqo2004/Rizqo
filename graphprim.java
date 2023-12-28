package Graph;

import java.util.*;

// Kelas Edge yang merepresentasikan sisi dengan bobot, dan dapat dibandingkan berdasarkan bobotnya.
class Edge implements Comparable<Edge> {
    String source;       // Node sumber sisi
    String destination;  // Node tujuan sisi
    int weight;          // Bobot sisi

    // Konstruktor untuk membuat sisi baru
    public Edge(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Metode untuk membandingkan dua sisi berdasarkan bobotnya
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

// Kelas graphprim yang menggunakan algoritma Prim untuk mencari Minimum Spanning Tree (MST).
public class graphprim {
    private Map<String, List<Edge>> adjacencyList; // Struktur data untuk menyimpan adjacency list dengan edge berbobot

    // Konstruktor untuk inisialisasi objek graphprim
    public graphprim() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan edge berbobot ke dalam graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot ke node sumber dan tujuan
        adjacencyList.get(source).add(new Edge(source, destination, weight));
        adjacencyList.get(destination).add(new Edge(destination, source, weight)); // Untuk graf tidak terarah
    }

    // Metode untuk mendapatkan daftar tetangga dan bobot dari suatu node
    public List<Edge> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Metode untuk menjalankan algoritma Prim dan mencetak Minimum Spanning Tree
    public void primMST(String start) {
        // PriorityQueue untuk memilih edge dengan bobot terkecil
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<String> inMST = new HashSet<>();
        Map<String, Edge> edgeTo = new HashMap<>();

        // Inisialisasi dengan node awal
        inMST.add(start);
        for (Edge edge : adjacencyList.getOrDefault(start, Collections.emptyList())) {
            pq.add(edge);
            edgeTo.put(edge.destination, edge);
        }

        int totalWeight = 0; // Variabel untuk menyimpan total bobot
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (inMST.contains(edge.destination)) continue;

            inMST.add(edge.destination);
            System.out.println(edgeTo.get(edge.destination).source + " - " + edge.destination + " [" + edge.weight + "]");
            totalWeight += edge.weight; // Menambahkan bobot edge ke total bobot

            for (Edge nextEdge : adjacencyList.getOrDefault(edge.destination, Collections.emptyList())) {
                if (!inMST.contains(nextEdge.destination)) {
                    pq.add(nextEdge);
                    edgeTo.put(nextEdge.destination, nextEdge);
                }
            }
        }

        System.out.println("Total bobot MST: " + totalWeight); // Mencetak total bobot
    }

    // Metode main untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek dari kelas graphprim
        graphprim graph = new graphprim();

        // Menambahkan node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        // Menambahkan edge atau sisi ke graf
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("B", "E", 10);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        
        // Menjalankan algoritma Prim dengan node awal "A"
        graph.primMST("A");
    }
}
