import java.util.Arrays;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class CreatingNumbers {
    public static void create() {
        int count = 1000;
        int maxNumber = 1_000_000;
        try { 
            FileWriter writer = new FileWriter("Arrays.txt");
            Random rand = new Random();
            for (int i = 0; i < count; i++) {
                int length = rand.nextInt(90_900) + 100;
                for (int j = 0; j < length; j++) {
                    writer.write(rand.nextInt(maxNumber) + " ");
                }
                writer.write("\n");
                System.out.println(i);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void read() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Arrays.txt"));
        String[] a = scan.nextLine().split(" ");
        System.out.println(a.length);
    }

    public static void main(String[] args) {
        create();
    }
}
