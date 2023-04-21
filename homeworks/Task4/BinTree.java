import javax.xml.transform.Source;

public class BinTree {
    public MyNode root;
    private int size;

    public BinTree(int value) {
        root = new MyNode(value);
        size = 1;
    }

    public void addElem(int value) {
        addElem(root, value);
        size++;
    }

    private MyNode addElem(MyNode pointer, int value) throws RuntimeException {
        if (pointer == null) {
            pointer = new MyNode(value);
        } else {
            if (pointer.value == value) {
                throw new RuntimeException("There can't contains equals values");
            }
            if (value < pointer.value) {
                pointer.left = addElem(pointer.left, value);
            } else {
                pointer.right = addElem(pointer.right, value);
            }
        }
        return pointer;
    }

    public boolean hasElem(int value) { 
        return hasElemHelper(value, root);
    }

    private boolean hasElemHelper(int value, MyNode pointer) {
        if (pointer.value == value) {
            return true;
        }

        pointer = value < pointer.value ? pointer.left : pointer.right;
        
        if (pointer == null) {
            return false;
        }

        return hasElemHelper(value, pointer);
    }

    public int[] toArray() {
        int[] arr = new int[size];
        arr[0] = root.value;
        toArrayHelper(arr, 0, root);
        return arr;
    }

    private void toArrayHelper(int[] arr, int i, MyNode pointer) {
        if (pointer.left != null) {
            arr[i*2 + 1] = pointer.left.value;
            toArrayHelper(arr, i + 1, pointer.left);
        }
        if (pointer.right != null) {
            arr[i*2 + 2] = pointer.right.value;
            toArrayHelper(arr, i + 2, pointer.right);
        }
    }

    public void show() {
        int[] treeNumbers = toArray();
        String treeText =  "";

        int gapsCount = (size - 1) / 2;
        int startGapsCount = gapsCount;
        int depth = 1;
        int index = 1;

        for (int i = 0; i < startGapsCount; i++) {
            treeText += " ";
        }
        treeText += treeNumbers[0] + "\n";
        startGapsCount -= 2;

        while (index < size) {

            for (int i = 0; i < startGapsCount; i++) {
                treeText += " ";
            }
            treeText += treeNumbers[index];
            index++;

            for (int j = 0; j < depth; j++) {
                for (int i = 0; i < gapsCount - depth + 1; i++) {
                    treeText += " ";
                }
                treeText += treeNumbers[index];
                index++;
            }
            treeText += "\n";
            startGapsCount -= 2;
            depth += 2;
        }
        System.out.println(treeText);

    }

}
