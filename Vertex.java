package assign07;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class represents a vertex or a node in a directed graph.
 * 
 * 
 * @author Lune Holliman & Ryan Powell
 * @version Oct 23 2026
 */

public class Vertex<T> {

	public T name;
	public double distance;

	public LinkedList<Edge<T>> adj;

	public int indegree;

	public boolean visited;

	public boolean hasPrevious;

	public Vertex<T> previous;

	/**
	 * this makes a new vertex name, with its variables
	 * 
	 * @param name - the name given to the specific node.
	 */

	public Vertex(T name) {
		this.distance = Double.MAX_VALUE;
		this.name = name;
		this.adj = new LinkedList<Edge<T>>();
		visited = false;
		hasPrevious = false;
		indegree = 0;

	}

	/**
	 * gets the name of the node
	 * 
	 * @return - returns the name
	 */
	public T getName() {
		return name;
	}

	/**
	 * returns the neighboring edges of the node/vertex.
	 * 
	 * @return - gets the neighbors.
	 */
	public LinkedList<Edge<T>> getAdjList() {
		return adj;
	}

	/**
	 * adds a edge to the vertex, with where it goes and its weight.
	 * 
	 * @param targetVertex - the target/destination vertex
	 * @param weight - weight of the edge
	 */
	public void addEdge(Vertex<T> targetVertex, double weight) {
		adj.add(new Edge<>(targetVertex, weight));
	}

}
