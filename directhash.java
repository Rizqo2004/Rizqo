package Hashtable;

// Kelas directhash untuk implementasi tabel hash langsung
public class directhash {

    private int[] table; // Array untuk menyimpan nilai

    // Konstruktor untuk inisialisasi tabel hash dengan ukuran tertentu
    public directhash(int size) {
        table = new int[size];
    }

    // Metode untuk menyisipkan nilai ke dalam tabel hash
    public void insert(int value) {
        table[value] = value; // Gunakan nilai sebagai kunci (indeks)
        System.out.println("Data: " + value + " dimasukan ke index: " + value);
    }

    // Metode untuk mencari nilai dalam tabel hash
    public int search(int value) {
        if (table[value] == value) {
            return table[value]; // Kembalikan nilai jika ditemukan
        }
        return -1; // Tidak ditemukan
    }

    // Metode main untuk menjalankan program
    public static void main(String[] args) {
        // Inisialisasi Direct Hash dengan ukuran array 200
        directhash directHash = new directhash(200);

        // Menyisipkan beberapa nilai
        directHash.insert(9);
        directHash.insert(50);
        directHash.insert(100);

        // Mencari nilai
        System.out.println("Hasil pencarian nilai 9 di Index: " + directHash.search(9));  // Harusnya mengembalikan 9
        System.out.println("Hasil pencarian nilai 50 di Index: " + directHash.search(50));  // Harusnya mengembalikan 50
        System.out.println("Hasil pencarian nilai 100 di Index: " + directHash.search(100));  // Harusnya mengembalikan 100

        // Mencari nilai yang tidak ada
        System.out.println("Hasil pencarian nilai 150 di Index: " + directHash.search(150));  // Harusnya mengembalikan -1 (tidak ditemukan)
    }
}
