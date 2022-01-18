package data.structure.graph.dijkstra;

import data.structure.flowevent.PathEvent;
import data.structure.flowevent.PathFlow;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    private final PathFlow.PathPublisher<PathEvent> publisher;
    private final PathFlow.PathSubscriber<PathEvent> subscriber;

    public DijkstraAlgorithm() {
        publisher = new PathFlow.PathPublisher<>();
        subscriber = new PathFlow.PathSubscriber<>();
        publisher.subscribe(subscriber);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A", List.of(Vertex.of("B", 6), Vertex.of("C", 10)));
        graph.addVertex("B", List.of(Vertex.of("A", 6), Vertex.of("C", 3), Vertex.of("D", 20)));
        graph.addVertex("C", List.of(Vertex.of("A", 10), Vertex.of("B", 3), Vertex.of("D", 15), Vertex.of("G", 17), Vertex.of("H", 7)));
        graph.addVertex("D", List.of(Vertex.of("B", 20), Vertex.of("C", 15), Vertex.of("G", 6)));
        graph.addVertex("H", List.of(Vertex.of("C", 7), Vertex.of("G", 9)));
        graph.addVertex("G", List.of(Vertex.of("H", 9), Vertex.of("C", 17), Vertex.of("D", 6)));

        new DijkstraAlgorithm().getShortestPath(graph, "A", "H");

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getShortestPath(Graph graph, String initial, String finish) {
        final var distances = new HashMap<String, Integer>();
        final var path = new HashMap<String, Vertex>();
        final var nodes = new PriorityQueue<Vertex>();

        distances.put(initial, 0);
        nodes.add(Vertex.of(initial, 0));

        while (!nodes.isEmpty()) {

            Vertex smallest = nodes.poll();
            publisher.submit(PathEvent.visit(smallest.getId()));

            if (smallest.getId().equals(finish)) {
                publisher.submit(PathEvent.stop(smallest.getId()));
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

        print(path, distances, finish);
    }

    private void print(HashMap<String, Vertex> path, HashMap<String, Integer> distances, String finish) {
        Vertex previousPath = path.get(finish);
        StringBuilder sb = new StringBuilder(60);
        sb.append(finish);

        while (previousPath != null) {
            sb.append(" >- ");
            sb.append(previousPath.getId());
            previousPath = path.get(previousPath.getId());
        }

        System.out.println(path);
        System.out.println(distances);
        System.out.println("Best way: " + sb.reverse());
        System.out.println("Distance: " + distances.get(finish));
    }
}