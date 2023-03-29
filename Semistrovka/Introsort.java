public class Introsort { 
    public static int count;
    public static void sort(int[] arr) {
        int n = arr.length;
        int depthLimit = (int) Math.floor(Math.log(n)) * 2;
        introsort(arr, 0, n - 1, depthLimit);
    }
    
    private static void introsort(int[] arr, int start, int end, int depthLimit) {
        count++;
        if (end - start < 16) {
            insertionSort(arr, start, end);
            return;
        }
        if (depthLimit == 0) {
            heapsort(arr, start, end);
            return;
        }
        int middleIndex = chooseMiddleIndex(arr, start, end);
        middleIndex = quickSortPart(arr, start, end, middleIndex);
        introsort(arr, start, middleIndex - 1, depthLimit - 1);
        introsort(arr, middleIndex + 1, end, depthLimit - 1);
    }

    private static int chooseMiddleIndex(int[] arr, int start, int end) {
        return start + (end - start) / 2;
    }

    private static int quickSortPart(int[] arr, int start, int end, int middleIndex) {
        int middleValue = arr[middleIndex];
        swap(arr, middleIndex, end);
        int storeIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < middleValue) {
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
}