package data.structure.graph.dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<String, List<Vertex>> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(String id, List<Vertex> adjacent) {
        this.vertices.put(id, adjacent);
    }

    public List<Vertex> getNeighbors(String id) {
        return vertices.get(id);
    }

    public Map<String, List<Vertex>> getVertices() {
        return vertices;
    }

}
