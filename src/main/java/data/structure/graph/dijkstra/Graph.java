package data.structure.graph.dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Graph {

    private final Map<String, List<Vertex>> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(String id, List<Vertex> adjacent) {
        this.vertices.put(id, adjacent);
    }

    public void getShortestPath(String initial, String finish) {
        final var distances = new HashMap<String, Integer>();
        final var previous = new HashMap<String, Vertex>();
        final var nodes = new PriorityQueue<Vertex>();

        vertices.entrySet().forEach(vertex -> {
            if (initial.equals(vertex.getKey())) {
                distances.put(vertex.getKey(), 0);
                nodes.add(Vertex.of(vertex.getKey(), 0));
            } else {
                distances.put(vertex.getKey(), Integer.MAX_VALUE);
                nodes.add(Vertex.of(vertex.getKey(), Integer.MAX_VALUE));
            }
            previous.put(vertex.getKey(), null);
        });

        while (!nodes.isEmpty()) {

            Vertex smallest = nodes.poll();

            for (Vertex vertex : vertices.get(smallest.getId())) {

                int distance = smallest.getDistance() + vertex.getDistance();
                if (distance < distances.get(vertex.getId())) {
                    distances.put(vertex.getId(), distance);
                    previous.put(vertex.getId(), smallest);
                    nodes.remove(vertex);
                    nodes.add(Vertex.of(vertex.getId(), distance));
                }
            }

            nodes.remove(smallest);
        }

        Vertex previousPath = previous.get(finish);
        StringBuilder sb = new StringBuilder(60);
        sb.append(finish);

        while (previousPath != null) {
            sb.append(" >- ");
            sb.append(previousPath.getId());
            previousPath = previous.get(previousPath.getId());
        }

        System.out.println(distances);
        System.out.println("Best way: " + sb.reverse());
        System.out.println("Distance: " + distances.get(finish));
    }
}
