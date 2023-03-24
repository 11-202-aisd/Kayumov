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
        if (connections[firstComputer] == connections[secondComputer]) {
            return false;
        }
        int max = connections[firstComputer] > connections[secondComputer] ? connections[firstComputer] : connections[secondComputer];
        int min = connections[firstComputer] + connections[secondComputer] - max;
        for (int i = 0; i < connections.length; i++) {
            if (connections[i] == min) {
                connections[i] = max;
            }
        }
        return true;
    }

    public boolean connect(int[][] pares) {
        for (int[] pare : pares) {
            connect(pare[0], pare[1]);
        }
        return true;
    }

    public boolean hasConnection(int firstComputer, int secondComputer) {
        return connections[firstComputer] == connections[secondComputer];
    }

    public boolean neetToConnect(int firstComputer, int secondComputer) {
        return !(hasConnection(firstComputer, secondComputer));
    }

    public String toString() {
        return Arrays.toString(connections);
    }
}
