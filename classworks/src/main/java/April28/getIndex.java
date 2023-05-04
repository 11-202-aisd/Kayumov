package April28;

public class getIndex {
    //Дан массив: до j-элемнента возрастает, после - убывает. Найти j
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,7,8,9,10,9,8,7,6,5,4};
        boolean flag = false;
        int left = 0;
        int right = arr.length;
        int median = (right + left) / 2;
        while (!flag && right > left) {
            System.out.println(left + " " + right + " " + median);
            if (arr[median] > arr[median - 1] && arr[median] > arr[median + 1]) {
                flag = true;
                break;
            }
            if (arr[median - 1] < arr[median] && arr[median] < arr[median + 1]) {
                left = median;
            } else {
                right = median;
            }
            median = (right + left) / 2;
        }
        System.out.println(arr[median] + " " + median);
    }
}
