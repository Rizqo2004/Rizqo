package Hashtable;

import java.util.LinkedList;

// Kelas stringhash untuk implementasi tabel hash dengan Separate Chaining untuk string
public class stringhash {

    // Ukuran tabel hash, sesuai dengan jumlah huruf dalam alfabet Inggris
    private static final int TABLE_SIZE = 26;
    
    // Array dari linked list untuk menyimpan string di setiap indeks tabel
    private LinkedList<String>[] table;

    // Konstruktor untuk inisialisasi tabel hash dengan linked list di setiap indeks
    public stringhash(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Metode untuk menghitung nilai hash dari sebuah string
    public int hashFunction(String key) {
        if (key.isEmpty()) {
            return 0; // Menangani kasus string kosong
        }
        return Math.abs(key.hashCode() % TABLE_SIZE);
    }

    // Metode untuk menyisipkan nilai ke dalam tabel hash menggunakan Separate Chaining
    public void insert(String value) {
        int index = hashFunction(value); // Hitung indeks
        table[index].add(value); // Tambahkan ke LinkedList di indeks tersebut
        System.out.println("Data " + value + " ditambahkan di index: " + index);
    }

    // Metode untuk mencari indeks dari suatu string dalam tabel hash
    public int search(String value) {
        int index = hashFunction(value); // Hitung indeks
        return index; // Cek apakah nilai ada di LinkedList di indeks tersebut
    }

    // Metode main untuk menjalankan program
    public static void main(String[] args) {
        // String Hash with Separate Chaining
        stringhash stringHash = new stringhash(TABLE_SIZE); // Membuat objek dengan ukuran 26 (A-Z)
        stringHash.insert("Honkai Impact 3rd"); // Menyisipkan string "Honkai Impact 3rd"
        stringHash.insert("Honkai Star rail"); // Menyisipkan string "Honkai Star rail"
        stringHash.insert("Genshin Impact");// Menyisipkan string "Genshin Impact"
        stringHash.insert("Black Clover Mobile");// Menyisipkan string "Black Clover Mobile"
        System.out.println("String Game HSR yang ditemukan di index: " + stringHash.search("Honkai Star rail")); // Mencari string "Honkai Star rail"
    }
}
