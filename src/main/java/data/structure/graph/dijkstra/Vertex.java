package data.structure.graph.dijkstra;

import java.util.Objects;

public class Vertex implements Comparable<Vertex> {

    private final Integer distance;
    private final String id;

    private Vertex(String id, Integer distance) {
        this.distance = distance;
        this.id = id;
    }

    public static Vertex of(String id, Integer distance) {
        return new Vertex(id, distance);
    }

    public Integer getDistance() {
        return distance;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Vertex vertex) {
        return distance.compareTo(vertex.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(id, vertex.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "distance=" + distance +
                ", id='" + id + '\'' +
                '}';
    }
}
