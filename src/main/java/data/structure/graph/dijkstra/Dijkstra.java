package data.structure.graph.dijkstra;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {

    private HashMap<String, Vertex> path;
    private HashMap<String, Integer> distances;
    private String finish;

    public void getShortestPath(Graph graph, String initial, String finish) {
        final var distances = new HashMap<String, Integer>();
        final var path = new HashMap<String, Vertex>();
        final var nodes = new PriorityQueue<Vertex>();

        distances.put(initial, 0);
        nodes.add(Vertex.of(initial, 0));

        while (!nodes.isEmpty()) {

            Vertex smallest = nodes.poll();

            if (smallest.getId().equals(finish)) {
                break;
            }

            for (Vertex vertex : graph.getNeighbors(smallest.getId())) {

                if (smallest.equals(vertex)) {
                    continue;
                }

                int distance = smallest.getDistance() + vertex.getDistance();
                if (!distances.containsKey(vertex.getId()) || distance < distances.get(vertex.getId())) {
                    distances.put(vertex.getId(), distance);
                    path.put(vertex.getId(), smallest);
                    nodes.remove(vertex);
                    nodes.add(Vertex.of(vertex.getId(), distance));
                }
            }

            nodes.remove(smallest);
        }

        this.path = path;
        this.distances = distances;
        this.finish = finish;
    }

    public String getFinish() {
        return finish;
    }

    public HashMap<String, Integer> getDistances() {
        return distances;
    }

    public HashMap<String, Vertex> getPath() {
        return path;
    }
}
