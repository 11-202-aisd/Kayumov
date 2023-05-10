package May5;

import java.util.Arrays;

public class getMinCountOfCoins {
    public static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static int count(int n, int[] nominals) {
        int[] counts = new int[n + 1];
        counts[0] = 0;
        for (int nominal : nominals) {
            counts[nominal] = 1;
        }
        return countHelper(n, counts, nominals);
    }

    public static int countHelper(int n, int[] counts, int[] nominals) {
        if (counts[n] == 0) {
            int[] arr = new int[nominals.length];
            for (int i = nominals.length - 1; i >= 0; i--) {
                if (n - nominals[i] >= 0) {
                    arr[i] = 1 + countHelper(n - nominals[i], counts, nominals);
                }
                else {
                    arr[i] = Integer.MAX_VALUE;
                }
            }
            counts[n] = min(arr);
        }
        return counts[n];
    }

    //Дана сумма, монеты номиналом 1, 2, 5, 10. Составить минимальное количество монет, чтобы была равная сумма
    public static void main(String[] args) {
        int[] nominals = new int[]{1, 2, 5, 10};
        int count = 0;
        int sum = 48;
        for (int i = nominals.length - 1; i >= 0; i--) {
            int currentNominal = nominals[i];
            int countOfCoinsOfCurrentNominal = sum / currentNominal;
            count += countOfCoinsOfCurrentNominal;
            sum -= countOfCoinsOfCurrentNominal * currentNominal;
        }
        System.out.println(count(16, new int[] {1, 4, 5}));//Для любого номинала и любой суммы
    }
}
