package data.structure.flowevent;

import java.util.concurrent.atomic.AtomicInteger;

public class PathEvent {

    enum TYPE {
        VISIT,
        REMOVE,
        UPDATE_DISTANCE,
        STOP
    }

    private final TYPE type;
    private final String node;
    private final Integer distance;
    private final Integer order;
    private final AtomicInteger atomicInteger = new AtomicInteger();

    private PathEvent(TYPE type, String node) {
        this(type, node, null);
    }

    private PathEvent(TYPE type, String node, Integer distance) {
        this.type = type;
        this.node = node;
        this.order = atomicInteger.getAndIncrement();
        this.distance = distance;
    }

    public static PathEvent visit(String node) {
        return new PathEvent(TYPE.VISIT, node);
    }

    public static PathEvent remove(String node) {
        return new PathEvent(TYPE.REMOVE, node);
    }

    public static PathEvent update(String node) {
        return new PathEvent(TYPE.UPDATE_DISTANCE, node);
    }

    public static PathEvent stop(String node) {
        return new PathEvent(TYPE.STOP, node);
    }

    public TYPE getType() {
        return type;
    }

    public String getNode() {
        return node;
    }

    public Integer getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "PathEvent{" +
                "type=" + type +
                ", node='" + node + '\'' +
                ", distance=" + distance +
                ", order=" + order +
                '}';
    }
}
