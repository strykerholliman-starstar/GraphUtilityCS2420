package assign07;

import java.util.LinkedList;

/**
 * This class represents a vertex within a directed graph.
 * 
 * 
 * @author Lune Holliman & Ryan Powell
 * @version Oct 29 2026
 */

public class Vertex<T> {
	public T data;
	public double distance;
	public LinkedList<Edge<T>> adj;
	public int indegree;
	public boolean visited;
	public boolean hasPrevious;
	public Vertex<T> previous;

	/**
	 * Constructs a new Vertex object
	 * 
	 * @param data - value of specific node.
	 */

	public Vertex(T data) {
		this.distance = Double.MAX_VALUE;
		this.data = data;
		this.adj = new LinkedList<Edge<T>>();
		visited = false;
		hasPrevious = false;
		indegree = 0;
	}

	/**
	 * Adds an edge to the vertex, treated as a pathway with a weight.
	 * 
	 * @param targetVertex - the target/destination vertex
	 * @param weight       - weight of the edge
	 */
	public void addEdge(Vertex<T> targetVertex, double weight) {
		adj.add(new Edge<>(targetVertex, weight));
	}

}
