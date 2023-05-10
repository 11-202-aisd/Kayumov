package TreeDataStructure;

import java.util.Arrays;

public class SegmentTree {
    private int[] tree;
    private int arrayLength;

    public SegmentTree(int number) {
        this(new int[] {number});
    }

    public SegmentTree(int[] arr) {
        arrayLength = arr.length;
        int treeLength = (1 << ((int) (Math.log(arrayLength - 1)/Math.log(2)) + 1)) * 2; //Количество элементов в дереве должно быть степенью 2
        tree = new int[treeLength];

        System.arraycopy(arr, 0, tree, tree.length / 2, arrayLength);
        treeUpdate();
    }

    public int sum(int l, int r) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (l < 0 || l >= arrayLength) {
            throw new IndexOutOfBoundsException("Index " + l + " out of bounds for length " + arrayLength);
        }
        if (r >= arrayLength) {
            throw new IndexOutOfBoundsException("Index " + r + " out of bounds for length " + arrayLength);
        }
        if (r < l) {
            throw new IllegalArgumentException("Index " + r + "must be more or equals " + l);
        }
        int result = 0;
        int count = 0; //Количество итераций
        l += tree.length / 2; r += tree.length / 2;
        while (l <= r) {
            if (l % 2 != 0) result += tree[l++];
            if (r % 2 == 0) result += tree[r--];
            l /= 2; r /= 2;
            count++;
        }
        System.out.println(count);
        return result;
    }
    
    private void treeUpdate() {
        for (int i = tree.length / 2 - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }
    
    private void nodeUpdate(int index) {
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
        }
    }

    public void set(int index, int number) throws IndexOutOfBoundsException {
        if (index >= arrayLength || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + arrayLength);
        }
        tree[tree.length / 2 + index] = number;
        nodeUpdate(tree.length / 2 + index);
    }

    public void add(int number) {
        if (arrayLength * 2 == tree.length) {
            tree = Arrays.copyOf(tree, tree.length * 2);
            System.arraycopy(tree, tree.length / 4, tree, tree.length / 2, arrayLength);
            treeUpdate();
        }
        set(++arrayLength - 1, number);
    }

    public void add(int[] numbers) {
        for (int number : numbers) {
            add(number);
        }
    }

    public int indexOf(int number) throws NullPointerException {
        for (int i = tree.length / 2; i < tree.length / 2 + arrayLength; i++) {
            if (tree[i] == number) {
                return i - tree.length / 2;
            }
        }
        throw new NullPointerException("Element " + number + " doesn't exist");
    }

    public int lastIndexOf(int number) throws NullPointerException {
        for (int i = tree.length / 2 + arrayLength - 1; i >= tree.length / 2; i--) {
            if (tree[i] == number) {
                return i - tree.length;
            }
        }
        throw new NullPointerException("Element " + number + " doesn't exist");
    }

    public void deleteByElement(int number) {
        int indexOfElement = indexOf(number);
        deleteByIndex(indexOfElement);
    }

    public void deleteByIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= arrayLength) {
            throw new IndexOutOfBoundsException("Index " + index + "out of bounds for length " + arrayLength);
        }
        for (int i = tree.length / 2 + index; i < tree.length / 2 + (arrayLength - 1); i++) {
            tree[i] = tree[i + 1];
        }
        tree[tree.length / 2 + (arrayLength - 1)] = 0;
        arrayLength--;
        if (arrayLength <= tree.length / 4) {
            for (int i = 0; i < arrayLength; i++) {
                tree[tree.length / 4 + i] = tree[tree.length / 2 + i];
            }
            tree = Arrays.copyOf(tree, tree.length / 2);
        }
        treeUpdate();
    }

    public int getArrayLength() {
        return arrayLength;
    }

    public int[] getTree() {
        return tree;
    }
}
