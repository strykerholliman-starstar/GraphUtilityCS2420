package assign07;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *  
 * 
 * 
 * @author Lune Holliman &  Ryan Powell
 * @version Oct 23 2026
 */

public class Vertex<T> {
	
	
	private T name;
	public double distance;
	// the adjancey list
	private LinkedList<Edge<T>> adj;
	// indegree of the vertex
	public int indegree;
	//checks if it has already been visited
	private boolean visited;
	// checks if it has a previous vertex to it
	private boolean hasPrevious;
	// sees what the previous vertex is.
	private Vertex<T> previous;
	
	public Vertex(T name) {
		this.distance = Double.MAX_VALUE;
		this.name = name;
		this.adj = new LinkedList<Edge<T>>();
		visited = false;
		hasPrevious = false;
		indegree = 0;
		
	
	}
	
	public T getName() {
		return name;
	}
	
	public LinkedList<Edge<T>> getAdjList() {
		return adj;
	}
	
	public void addEdge(Vertex<T> targetVertex, double weight) {
		adj.add(new Edge<>(targetVertex, weight));
	}

}
