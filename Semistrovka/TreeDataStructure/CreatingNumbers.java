package TreeDataStructure;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class CreatingNumbers {
    final static int COUNT = 10_000;
    public static void create() {
        int maxNumber = 10_000;
        try { 
            FileWriter writer = new FileWriter("D:\\Java\\Kayumov\\Semistrovka\\TreeDataStructure\\Array.txt");
            Random rand = new Random();
            for (int i = 0; i < COUNT; i++) {
                int number = rand.nextInt(maxNumber);
                writer.write(number + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void read() {
        try {
            Scanner scan = new Scanner(new File("D:\\Java\\Kayumov\\Semistrovka\\TreeDataStructure\\Array.txt"));
            int[] numbers = new int[COUNT];
            for (int i = 0; i < COUNT; i++) {
                numbers[i] = scan.nextInt();
            }
            System.out.println(Arrays.toString(numbers));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        create();
    }
}
