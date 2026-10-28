package assign07;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * 
 * 
 * @author Lune Holliman & Ryan Powell
 * @version Oct 23 2026
 */

public class Vertex<T> {

	public T data;
	public double distance;
	public LinkedList<Edge<T>> adj;
	public int indegree;
	public boolean visited;
	public Vertex<T> previous;

	public Vertex(T data) {
		this.distance = Double.MAX_VALUE;
		this.data = data;
		this.adj = new LinkedList<Edge<T>>();
		visited = false;
		indegree = 0;
	}

	public Edge<T> smallestUnvisitedEdge() {
		Iterator<Edge<T>> itr = adj.iterator();
		Edge<T> smallest = null, current;
		if (itr.hasNext())
			smallest = itr.next();
		while (itr.hasNext()) {
			current = itr.next();
			if (!current.getDestination().visited)
				if (current.getWeight() < smallest.getWeight())
					smallest = current;
		}
		return smallest;
	}

	public void addEdge(Vertex<T> targetVertex, double weight) {
		adj.add(new Edge<>(targetVertex, weight));
	}

}
