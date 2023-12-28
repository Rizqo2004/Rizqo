package Sorting;

public class selectsort {
    // Metode untuk melakukan pengurutan array menggunakan metode selection sort
    public static int[] selectionSort(int[] array) {
        int size = array.length; // Mendapatkan ukuran array

        // Melakukan iterasi selama masih ada elemen yang belum diurutkan
        while (size > 0) {
            int max = 0; // Mengasumsikan elemen pertama (index 0) adalah yang terbesar

            // Mencari elemen terbesar dalam subarray yang belum diurutkan
            for (int i = 1; i < size; i++) {
                if (array[max] < array[i]) {
                    max = i; // Menemukan elemen baru yang lebih besar
                }
            }

            // Menukar elemen terbesar dengan elemen di akhir subarray yang belum diurutkan
            int temp = array[max];
            array[max] = array[size - 1];
            array[size - 1] = temp;

            // Mengurangi ukuran subarray yang belum diurutkan karena elemen terbesar sudah di tempat yang tepat
            size--;
        }

        return array; // Mengembalikan array yang sudah diurutkan
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90}; // Array yang akan diurutkan
        int[] sortedArray = selectionSort(array); // Memanggil metode selectionSort untuk mengurutkan array

        // Mencetak array yang sudah diurutkan dalam urutan menurun
        System.out.println("Sorted array in descending order:");

        // Loop untuk mencetak setiap nilai dalam array yang sudah diurutkan
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
    }
}
