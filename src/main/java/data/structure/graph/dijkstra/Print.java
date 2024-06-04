package data.structure.graph.dijkstra;

public class Print {

    public static void print(Dijkstra dijkstra) {
        var path = dijkstra.getPath();
        var finish = dijkstra.getFinish();
        var distances = dijkstra.getDistances();

        Vertex previousPath = path.get(finish);
        StringBuilder sb = new StringBuilder(60);
        sb.append(finish);

        while (previousPath != null) {
            sb.append(" >- ");
            sb.append(previousPath.getId());
            previousPath = path.get(previousPath.getId());
        }

        System.out.println();
        System.out.println("Path: " + path);
        System.out.println("Dist: " + distances);
        System.out.println("Best way: " + sb.reverse());
        System.out.println("Distance: " + distances.get(finish));
        System.out.println();
    }
}
