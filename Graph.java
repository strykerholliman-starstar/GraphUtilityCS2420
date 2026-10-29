package assign07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
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
		if (!vertices.containsKey(name))
			vertices.put(name, new Vertex<>(name));
	}

	public List<Type> breadthFirstSearch(Type source, Type destination) {
		if (!vertices.containsKey(source) || !vertices.containsKey(destination))
			throw new IllegalArgumentException("Source or destination vertex does not exist in the graph");
		for (Vertex<Type> v : vertices.values()) {
			v.distance = Double.MAX_VALUE;
			v.previous = null;
		}
		Queue<Vertex<Type>> queue = new LinkedList<>();
		Vertex<Type> src = vertices.get(source);
		src.distance = 0.0;
		queue.offer(src);
		boolean reached = false;
		while (!queue.isEmpty()) {
			Vertex<Type> tempVertex = queue.poll();
			if (tempVertex.name.equals(destination)) {
				reached = true;
				break;
			}
			for (Edge<Type> e : tempVertex.adj) {
				Vertex<Type> neighbor = e.getDestination();
				if (neighbor.distance == Double.MAX_VALUE) {
					neighbor.distance = tempVertex.distance + 1.0;
					neighbor.previous = tempVertex;
					queue.offer(neighbor);
				}
			}
		}
		List<Type> returnList = new ArrayList<>();
		Vertex<Type> destinationVertex = vertices.get(destination);
		if (!reached && destinationVertex.previous == null && !source.equals(destination))
			throw new IllegalArgumentException("Source or destination vertex does not exist in the graph");
		Vertex<Type> curr = destinationVertex;
		while (curr != null) {
			returnList.add(curr.name);
			curr = curr.previous;
		}
		Collections.reverse(returnList);
		return returnList;
	}

	public List<Type> dijkstrasAlgorithm(Type source, Type destination) {
		if (!vertices.containsKey(source) || !vertices.containsKey(destination))
			throw new IllegalArgumentException("Source or destination vertex does not exist in the graph");
		for (Vertex<Type> v : vertices.values()) {
			v.distance = Double.MAX_VALUE;
			v.previous = null;
		}
		Vertex<Type> srcVertex = vertices.get(source);
		srcVertex.distance = 0.0;
		ArrayList<Vertex<Type>> unvisited = new ArrayList<>(vertices.values());
		while (!unvisited.isEmpty()) {
			unvisited.sort(new CompareByDistFromStartReverse<Type>());
			Vertex<Type> current = unvisited.remove(unvisited.size() - 1);
			if (current.distance == Double.MAX_VALUE)
				break;
			for (Edge<Type> e : current.adj) {
				Vertex<Type> neighbor = e.getDestination();
				double newDistance = current.distance + e.weight;
				if (newDistance < neighbor.distance) {
					neighbor.distance = newDistance;
					neighbor.previous = current;
				}
			}
		}
		ArrayList<Type> returnList = new ArrayList<>();
		Vertex<Type> destinationVertex = vertices.get(destination);
		if (destinationVertex.distance == Double.MAX_VALUE && !source.equals(destination))
			return returnList;
		Vertex<Type> curr = destinationVertex;
		while (curr != null) {
			returnList.add(curr.name);
			curr = curr.previous;
		}
		Collections.reverse(returnList);
		return returnList;
	}

	public List<Type> topoSort() {
		for (Vertex<Type> v1 : vertices.values())
			v1.indegree = 0;
		for (Vertex<Type> v2 : vertices.values())
			for (Edge<Type> edge : v2.getAdjList())
				edge.getDestination().indegree++;
		Queue<Vertex<Type>> queue = new LinkedList<>();
		for (Vertex<Type> v3 : vertices.values())
			if (v3.indegree == 0)
				queue.add(v3);
		List<Type> sortedList = new ArrayList<>();
		while (!queue.isEmpty()) {
			Vertex<Type> current = queue.poll();
			sortedList.add(current.getName());
			for (Edge<Type> edge : current.getAdjList()) {
				Vertex<Type> neighbor = edge.getDestination();
				neighbor.indegree--;
				if (neighbor.indegree == 0)
					queue.add(neighbor);

			}
		}

		if (sortedList.size() != vertices.size())
			throw new IllegalArgumentException("The graph has a cycle");
		return sortedList;

	}
}
