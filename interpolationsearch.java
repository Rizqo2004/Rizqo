package Searching;

public class interpolationsearch {
    static int found;

    // Metode interpolation search yang mengembalikan nilai boolean
    static boolean interpolation(int[] array, int find) {
        int high = array.length - 1;
        int low = 0;
        boolean hasil = false;
        int mid;

        while (low < high) {
            // Formula untuk menghitung posisi perkiraan nilai dalam array terurut
            mid = low + ((high - low) * ((find - array[low]) / (array[high] - array[low])));

            if (mid > high)
                mid = high;

            // Jika nilai yang dicari ditemukan di posisi perkiraan
            if (find == array[mid]) {
                hasil = true;
                found = mid;
                break;
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
        int searchValue = 10; // Nilai yang akan dicari

        // Memanggil metode interpolation search
        boolean result = interpolation(dataArray, searchValue);

        // Menampilkan hasil pencarian
        if (result) {
            System.out.println("Nilai " + searchValue + " ditemukan pada indeks: " + getfound());
        } else {
            System.out.println("Nilai " + searchValue + " tidak ditemukan dalam array.");
        }
    }
}
