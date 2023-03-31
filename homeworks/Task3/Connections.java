import java.util.Arrays;


public class Connections {
    private int[] connections;
    

    public Connections(int length) {    
        connections = new int[length];
        for (int i = 0; i < length; i++) {
            connections[i] = i;
        }
    }

    public boolean connect(int firstComputer, int secondComputer) {
        if (hasConnection(firstComputer, secondComputer)) {
            return false;
        }
        while (connections[secondComputer] != secondComputer || connections[firstComputer] != firstComputer) {
            secondComputer = connections[secondComputer];
            firstComputer = connections[firstComputer];
        }
        connections[firstComputer] = secondComputer;
        return true;
    }

    public boolean connect(int[][] pares) {
        for (int[] pare : pares) {
            connect(pare[0], pare[1]);
        }
        return true;
    }

    public boolean hasConnection(int firstComputer, int secondComputer) {
        int i = firstComputer, j = secondComputer;
        while (connections[firstComputer] != firstComputer || connections[secondComputer] != secondComputer) {
            firstComputer = connections[firstComputer];
            secondComputer = connections[secondComputer];
        }
        return firstComputer == secondComputer;
    }

    public boolean neetToConnect(int firstComputer, int secondComputer) {
        return !(hasConnection(firstComputer, secondComputer));
    }

    public String toString() {
        return Arrays.toString(connections);
    }
}
