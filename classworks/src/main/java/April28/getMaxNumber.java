package April28;

import java.util.Arrays;

public class getMaxNumber {
    //Дан массив из натуральных чисел. Составить максимальное число из этих чисел
    public static void swap(int[] arr, int a, int b) {
        int swapper = arr[b];
        arr[b] = arr[a];
        arr[a] = swapper;
    }
    public static void main(String[] args)  {
        String result = "";
        int[] arr = new int[] {102, 3, 5, 4, 6, 65, 6, 13};
        for (int i = 0; i < arr.length - 1; i++) {
            int countOfDigits = (int) (Math.pow(10, (int) (Math.log10(arr[i]))));
            int reference = arr[i] / countOfDigits;
            System.out.print(Arrays.toString(arr) + " " + arr[i] + " " + i + " " + reference + " ");
            System.out.println(countOfDigits + " ");
            for (int j = i + 1; j < arr.length; j++) {
                int comparable = arr[j] / (int) (Math.pow(10, Math.log10(arr[j])));
                System.out.println(comparable);
                if (reference > comparable) {
                    swap(arr, i, j);
                    continue;
                }
                if (reference == comparable) {
                    swap(arr, i + 1, j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
