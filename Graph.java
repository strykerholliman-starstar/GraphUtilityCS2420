package assign07;

import java.util.*;

/**
 * 
 * 
 * 
 * @author Lune Holliman & Ryan Powell
 * @version Oct 23 2026
 */

public class Graph<Type> {
	private Map<Type, Vertex<Type>> vertices;

	// makes a graph
	public Graph() {
		vertices = new HashMap<>();
	}

	// gets the name of the vertex
	public Vertex<Type> getVertex(Type data) {
		return vertices.get(data);
	}

	// adding edge
	public void addEdge(Type source, Type destination, double weight) {
		addVertex(source);
		addVertex(destination);
		Vertex<Type> SourceVertex = vertices.get(source);
		Vertex<Type> DestinationVertex = vertices.get(destination);
		SourceVertex.addEdge(DestinationVertex, weight);

	}

	public void addVertex(Type name) {

	}

	public List<Type> breadthFirstSearch(Type source, Type destination) {

	}

	public List<Type> dijkstrasAlgorithm(Type source, Type destination) {

	}

	public List<Type> topoSort() {
		for (Vertex<Type> v1 : vertices.values()) {
			v1.indegree = 0;
		}
		for (Vertex<Type> v2 : vertices.values()) {
			for (Edge<Type> edge : v2.getAdjList()) {
				edge.getDestination().indegree++;
			}
		}

		Queue<Vertex<Type>> queue = new LinkedList<>();
		for (Vertex<Type> v3 : vertices.values()) {
			if (v3.indegree == 0) {
				queue.add(v3);
			}
		}

		List<Type> sortedList = new ArrayList<>();
		while (!queue.isEmpty()) {
			Vertex<Type> current = queue.poll();
			sortedList.add(current.getName());

			for (Edge<Type> edge : current.getAdjList()) {
				Vertex<Type> neighbor = edge.getDestination();
				neighbor.indegree--;
				if (neighbor.indegree == 0) {
					queue.add(neighbor);
				}
			}
		}

		if (sortedList.size() != vertices.size()) {
			throw new IllegalArgumentException("");
		}

		return sortedList;

	}
}
