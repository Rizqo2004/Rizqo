package Sorting;

public class insertsort {
    // Metode untuk mengurutkan array menggunakan metode insertion sort
    public static int[] insertion(int[] array) {
        int size = array.length; // Ukuran array
        int max, j; // Variabel untuk menyimpan nilai maksimum dan indeks
        int i = 1; // Variabel untuk indeks elemen kedua dalam array

        // Perulangan untuk menelusuri seluruh array
        while (i < size) {
            max = array[i];
            j = i;

            // Pindahkan elemen yang lebih besar dari max satu posisi ke kanan
            while (j > 0 && array[j - 1] > max) {
                array[j] = array[j - 1];
                j--;
            }

            // Letakkan max di posisi yang tepat
            array[j] = max;
            i++;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = { 9, 5, 1, 4, 3 };
        int[] sortedArray = insertion(array);

        // Mencetak array yang sudah diurutkan
        System.out.println("Sorted array:");

        // Loop untuk mencetak setiap nilai dalam array yang sudah diurutkan
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
    }
}
