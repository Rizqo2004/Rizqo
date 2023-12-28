package Graph;


import java.util.*;

// Mendefinisikan kelas Sisi untuk merepresentasikan edge dengan bobot
class Sisi {
    String destination; // Node tujuan dari edge
    int weight; // Bobot (weight) dari edge

    // Konstruktor untuk membuat objek Sisi dengan node tujuan dan bobot
    public Sisi(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Mendefinisikan kelas graphdijkstra untuk merepresentasikan graf dengan algoritma Dijkstra
public class graphdijikstra {
    private Map<String, List<Sisi>> adjacencyList = new HashMap<>(); // Struktur data untuk menyimpan adjacency list dengan edge berbobot

    // Method untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Method untuk menambahkan edge berbobot ke dalam graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan kedua node (sumber dan tujuan) sudah ada dalam adjacencyList.
        addNode(source);
        addNode(destination);

        // Tambahkan edge berbobot ke node sumber dan tujuan
        adjacencyList.get(source).add(new Sisi(destination, weight));
        // Untuk graf tidak terarah, tambahkan baris berikut:
        adjacencyList.get(destination).add(new Sisi(source, weight));
    }

    // Method untuk menjalankan algoritma Dijkstra dan menghitung jarak terpendek dari start ke end
    public int dijkstra(String start, String end) {
        // Priority Queue untuk menyimpan node yang akan dieksplorasi berdasarkan jarak terpendek
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        // Map untuk menyimpan jarak terpendek dari start ke setiap node
        Map<String, Integer> distances = new HashMap<>();
        // Set untuk menyimpan node yang sudah dieksplorasi
        Set<String> settled = new HashSet<>();

        // Inisialisasi jarak semua node dengan nilai tak terhingga
        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        // Jarak dari start ke start adalah 0
        distances.put(start, 0);
        // Menambahkan start ke Priority Queue
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        // Proses algoritma Dijkstra
        while (!pq.isEmpty()) {
            String current = pq.poll().getKey();
            // Jika node yang dieksplorasi adalah node tujuan, kembalikan jarak terpendek
            if (current.equals(end)) {
                return distances.get(end);
            }

            // Jika node sudah dieksplorasi, lanjutkan ke node berikutnya
            if (settled.contains(current)) {
                continue;
            }
            settled.add(current);

            // Iterasi melalui setiap edge dari node yang sedang dieksplorasi
            for (Sisi edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                // Jika node tujuan belum dieksplorasi
                if (!settled.contains(edge.destination)) {
                    // Hitung jarak baru
                    int newDistance = distances.get(current) + edge.weight;
                    // Jika jarak baru lebih kecil dari jarak saat ini, update jarak
                    if (newDistance < distances.get(edge.destination)) {
                        distances.put(edge.destination, newDistance);
                        // Tambahkan node tujuan dan jarak baru ke Priority Queue
                        pq.add(new AbstractMap.SimpleEntry<>(edge.destination, newDistance));
                    }
                }
            }
        }

        // Jika tidak ada jalur dari start ke end, kembalikan nilai tak terhingga
        return distances.get(end);
    }

    // Method utama untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek dari kelas GraphDijkstra
        graphdijikstra graph = new graphdijikstra();
        
        

        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "B", 12);
        graph.addEdge("A", "E", 8);
        graph.addEdge("B", "E", 10);
        
        // Jalankan algoritma Dijkstra dari node "A" ke node "E"
        int distance = graph.dijkstra("A", "C");
        System.out.println("Jarak dari NodeAwal ke NodeAkhir adalah " + distance);
    }
}
