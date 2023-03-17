public class Task1 {
    public static void main(String[] args) {
        int[] a = {8, 15, 3, 9, 12, 19, 14};
        int[] b = new int[a.length];
        b[0] = -1;
        int index = 0;
        b[1] = index;
        int min = a[index];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                index = i;
            }
            b[i] = index;
        }
        for (int i : b) {
            System.out.print(i + " ");
        }
    }    
}
