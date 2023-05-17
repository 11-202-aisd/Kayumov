public class Connect {
    public static void main(String[] args) {
        int length = 10;
        int[][] pares = {{3,4}, {4,9}, {8,0}, {2,3}, {5,6}, {3,5}};
        Connections graph = new Connections(length);
        graph.connect(pares);
        System.out.println(graph.toString());
        System.out.println(graph.hasConnection(3,5));
    }
}
