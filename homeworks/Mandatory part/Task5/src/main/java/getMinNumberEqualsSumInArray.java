import java.util.Arrays;
import java.util.Random;

public class getMinNumberEqualsSumInArray {
    public static boolean[][] getAllKindsSum(int[] arr) {
        int maxNumber = Arrays.stream(arr).max().getAsInt();
        boolean[][] allKindsSum = new boolean[arr.length + 1][maxNumber + 1];
        allKindsSum[0][0] = true;
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 0; j <= maxNumber; j++) {
                if (allKindsSum[i - 1][j]) {
                    allKindsSum[i][j] = true;
                    if (j + arr[i - 1] <= maxNumber) {
                        if (j != 0) allKindsSum[0][j + arr[i - 1]] = true;
                        allKindsSum[i][j + arr[i - 1]] = true;
                    }
                }
            }
        }
        return allKindsSum;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int arrayLength = random.nextInt(6) + 5;
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = random.nextInt(20) + 1;
        }
        int minValue = Arrays.stream(arr).max().getAsInt();
        boolean isExist = false;
        boolean[][] allKindsSum = getAllKindsSum(arr);
        for (int k : arr) {
            if (k != minValue && allKindsSum[0][k] && allKindsSum[arrayLength][k]) {
                minValue = Math.min(minValue, k);
                isExist = true;
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(arr).sorted().toArray()));
        System.out.println(isExist ? minValue : "doesn't exist");
    }
}
