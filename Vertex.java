import java.util.*;

public class Vertex {
    private final String key;

    public Vertex (String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(key, vertex.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
