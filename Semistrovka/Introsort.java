import java.util.Scanner;
import java.io.*;

public class Introsort { 
    public static int count;
    public static void introsort(int[] arr) {
        int n = arr.length;
        int depthLimit = (int) Math.floor(Math.log(n)) * 2;
        introsortHelper(arr, 0, n - 1, depthLimit);
    }
    
    private static void introsortHelper(int[] arr, int start, int end, int depthLimit) {
        count++;
        if (end - start < 16) {
            insertionSort(arr, start, end);
            return;
        }
        if (depthLimit == 0) {
            heapsort(arr, start, end);
            return;
        }
        int pivotIndex = choosePivotIndex(arr, start, end);
        pivotIndex = partition(arr, start, end, pivotIndex);
        introsortHelper(arr, start, pivotIndex - 1, depthLimit - 1);
        introsortHelper(arr, pivotIndex + 1, end, depthLimit - 1);
    }

    private static int choosePivotIndex(int[] arr, int start, int end) {
        return start + (end - start) / 2;
    }

    private static int partition(int[] arr, int start, int end, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, end);
        int storeIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, end);
        return storeIndex;
    }

    private static void insertionSort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void heapsort(int[] arr, int start, int end) {
        for (int i = (end - 1) / 2; i >= start; i--) {
            heapify(arr, i, end);
        }
        for (int i = end; i >= start + 1; i--) {
            swap(arr, start, i);
            heapify(arr, start, i - 1);
        }
    }

    private static void heapify(int[] arr, int parent, int end) {
        int child = 2 * parent + 1;
        while (child <= end) {
            if (child + 1 <= end && arr[child] < arr[child + 1]) {
                child++;
            }
            if (arr[parent] >= arr[child]) {
                return;
            }
            swap(arr, parent, child);
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("Arrays.txt"));
        FileWriter writer = new FileWriter("results.txt");
        int progress = 1;
        while (scan.hasNextLine()) {
            String[] patt = scan.nextLine().split(" ");
            int[] arr = new int[patt.length]; 
            for (int i = 0; i < patt.length; i++) {
                arr[i] = Integer.parseInt(patt[i]);
            }
            count = 0;
            long startTime = System.nanoTime();
            introsort(arr);
            long endTime = System.nanoTime();
            writer.write(patt.length + " " + count + " " + (endTime - startTime) + "\n");
            System.out.println(progress++);
        }
        writer.close();
    }
}