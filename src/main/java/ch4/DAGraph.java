package ch4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DAGraph<T> {

    private Map<T, List<T>> adj;
    private Set<T> values;

    public DAGraph() {
        this.adj = new HashMap<>();
        this.values = new HashSet<>();
    }

    public List<T> getAdj (T a) {
        return adj.getOrDefault(a, new ArrayList<>());
    }

    public void addEdge(T a, T b) {
        adj.putIfAbsent(a, new ArrayList<>());
        adj.get(a).add(b);
        values.add(a);
        values.add(b);
    }
    public int getSize() {
        return values.size();
    }

    public T getRandomVertix() {
        return adj.keySet().stream().findAny().get();
    }

    public Set<T> getVertices() {
        return values;
    }
}
