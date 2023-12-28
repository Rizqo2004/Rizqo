package Searching;

// Kelas sequencialsearch untuk implementasi pencarian sekuensial
public class sequencialsearch {

    public static void main(String[] args) {
        // Inisialisasi array data yang akan dicari
        int data[] = {10, 8, 11, 20, 27, 99, 21, 5, 41, 17};
        int searchValue = 21; // Nilai yang dicari dalam array
        int index = 0; // Variabel untuk menyimpan indeks tempat nilai ditemukan
        boolean found = false; // Variabel penanda apakah nilai ditemukan atau tidak

        // Melakukan pencarian sekuensial dengan menggunakan perulangan for
        for (index = 0; index < data.length; index++) {
            // Memeriksa apakah nilai pada indeks saat ini sama dengan nilai yang dicari
            if (data[index] == searchValue) {
                found = true; // Menandai bahwa nilai ditemukan
                break; // Keluar dari perulangan jika nilai ditemukan
            }
        }

        // Menampilkan hasil pencarian
        if (found) {
            System.out.println("Data: " + searchValue + " Ditemukan pada index: " + index + ".");
        } else {
            System.out.println("Data " + searchValue + " Tidak Ditemukan");
        }
    }
}
