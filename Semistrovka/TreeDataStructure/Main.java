package TreeDataStructure;

import java.io.File;
import java.io.*;
import java.util.*;

public class Main {
    public static void timeForAdd(int[] arr) throws IOException {
        SegmentTree tree = new SegmentTree(arr[0]);
        FileWriter writer = new FileWriter("D:\\Java\\Kayumov\\Semistrovka\\TreeDataStructure\\Results.txt", true);
        writer.write("Time values for add:");
        double average = 0;
        for (int i = 1; i < arr.length; i++) {
            long start = System.nanoTime();

            tree.add(arr[i]);

            long finish = System.nanoTime();
            int result = (int) (finish - start);
            average += result;
            writer.write(" " + result);
        }
        writer.write("\nAverage time: " + String.format("%.2f", average / arr.length - 1) + "\n");
        writer.flush();
    }

    public static void timeForIndexing(int[] arr) throws IOException {
        SegmentTree tree = new SegmentTree(arr);
        FileWriter writer = new FileWriter("D:\\Java\\Kayumov\\Semistrovka\\TreeDataStructure\\Results.txt", true);
        writer.write("Time values for indexing:");
        Random rand = new Random();
        double average = 0;
        for (int i = 0; i < 100; i++) {
            int randIndex = rand.nextInt(arr.length);
            int indexingElement = arr[randIndex];
            long start = System.nanoTime();

            tree.indexOf(indexingElement);

            long finish = System.nanoTime();
            int result = (int) (finish - start);
            average += result;
            writer.write(" " + result);
        }
        writer.write("\nAverage time: " + String.format("%.2f", average / 100) + "\n");
        writer.flush();
    }

    public static void timeForDelete(int[] arr) throws IOException {
        SegmentTree tree = new SegmentTree(arr);
        FileWriter writer = new FileWriter("D:\\Java\\Kayumov\\Semistrovka\\TreeDataStructure\\Results.txt", true);
        writer.write("Time values for delete:");
        Random rand = new Random();
        List<Integer> arrList = new ArrayList<>();
        for (int number : arr) {
            arrList.add(number);
        }
        double average = 0;
        for (int i = 1; i <= 1000; i++) {
            int randIndex;
            int deletedElement;
            do {
                randIndex = rand.nextInt(tree.getArrayLength());
                deletedElement = arr[randIndex];
            } while (deletedElement == -1);
            arr[randIndex] = -1;

            long start = System.nanoTime();

            tree.deleteByElement(deletedElement);

            long finish = System.nanoTime();
            int result = (int) (finish - start);
            average += result;
            writer.write(" " + result);
        }
        writer.write("\nAverage time: " + String.format("%.2f", average / 1000) + "\n");
        writer.flush();
    }

    public static void timeForSums(int[] arr) throws IOException {
        SegmentTree tree = new SegmentTree(arr);
        FileWriter writer = new FileWriter("D:\\Java\\Kayumov\\Semistrovka\\TreeDataStructure\\Results.txt", true);
        writer.write("Time values for sums:");
        Random random = new Random();
        final int COUNT_OF_TESTS = 1000;
        double average = 0;
        for (int i = 0; i < COUNT_OF_TESTS; i++) {
            int l = random.nextInt(arr.length);
            int r = random.nextInt(l, arr.length);

            long start = System.nanoTime();

            tree.sum(l, r);

            long finish = System.nanoTime();
            int result = (int) (finish - start);
            writer.write(" " + result);
            average += result;
        }
        writer.write("\nAverage time: " + String.format("%.2f", average / COUNT_OF_TESTS) + "\n");
        writer.flush();
    }

    public static void countOfOperationForSum(int[] arr) {
        SegmentTree tree = new SegmentTree(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr.length - i + " - ");
            tree.sum(i, arr.length - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("D:\\Java\\Kayumov\\Semistrovka\\TreeDataStructure\\Array.txt"));
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        scanner.close();
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        timeForAdd(arr);
        timeForDelete(arr);
        timeForIndexing(arr);
        timeForSums(arr);
        countOfOperationForSum(arr);
    }
}
