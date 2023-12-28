package Sorting;

public class bubblesort {

    // Metode untuk melakukan Bubble Sort
    void bubbleSort(int arr[]) {
        int n = arr.length; // Mendapatkan panjang dari array

        // Loop luar dari awal sampai hampir akhir array
        for (int i = 0; i < n-1; i++) {
            
            // Loop dalam untuk perbandingan dan pertukaran
            for (int j = 0; j < n-i-1; j++) {
                
                // Jika elemen saat ini lebih besar dari yang berikutnya
                if (arr[j] > arr[j+1]) {
                    // Pertukaran elemen
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Metode main untuk menguji Bubble Sort
    public static void main(String args[]) {
        bubblesort ob = new bubblesort(); // Membuat instansi dari kelas bubblesort
        int arr[] = {64, 34, 25, 12, 22, 11, 90}; // Array yang akan diurutkan

        ob.bubbleSort(arr); // Memanggil metode bubbleSort

        System.out.println("Sorted array"); // Mencetak pesan

        // Loop untuk mencetak array yang sudah diurutkan
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
