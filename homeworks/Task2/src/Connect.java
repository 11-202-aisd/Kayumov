public class Connect {
    public static void main(String[] args) {
        int length = 10;
        int[][] pares = {{5,7}, {2,3}, {4,5}, {4,7}, {1,2}, {1,3}};
        Connections graph = new Connections(length);
        graph.add(pares);
        System.out.println(graph.neetToConnect(3, 1));
    }
}
