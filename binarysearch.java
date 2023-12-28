package Searching;

public class binarysearch {
    static int found;

    // Metode binary search yang mengembalikan nilai boolean
    static boolean binary(int[] array, int find) {
        int high = array.length - 1;
        int low = 0;
        boolean hasil = false;

        // Perulangan binary search
        while (low <= high) {
            int mid = (high + low) / 2; // Temukan nilai tengah array

            // Jika nilai yang dicari ditemukan di tengah array
            if (find == array[mid]) {
                found = mid; // Simpan indeks nilai yang ditemukan
                hasil = true; // Set hasil pencarian menjadi true
                break; // Keluar dari perulangan
            } else if (find > array[mid])
                low = mid + 1; // Pindah ke setengah kanan array
            else
                high = mid - 1; // Pindah ke setengah kiri array
        }

        return hasil; // Kembalikan hasil pencarian
    }

    // Metode untuk mendapatkan nilai indeks yang ditemukan
    static int getfound() {
        return found;
    }

    public static void main(String[] args) {
        int[] dataArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Array yang akan dicari
        int searchValue = 6; // Nilai yang akan dicari

        // Memanggil metode binary search
        boolean result = binary(dataArray, searchValue);

        // Menampilkan hasil pencarian
        if (result) {
            System.out.println("Nilai " + searchValue + " ditemukan pada indeks: " + getfound());
        } else {
            System.out.println("Nilai " + searchValue + " tidak ditemukan dalam array.");
        }
    }
}
