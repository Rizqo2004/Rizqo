package Graph;

import java.util.*;

// Kelas graphstring untuk merepresentasikan graf dengan node dan sisi bertipe String.
public class graphstring {
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk inisialisasi objek graphstring
    public graphstring() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan edge atau sisi ke dalam graf
    public void addEdge(String source, String destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
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
        // Membuat objek dari kelas graphstring
        graphstring graph = new graphstring();

        // Menambahkan node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge atau sisi ke graf
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        // Mencetak graf
        graph.printGraph();
    }
}
