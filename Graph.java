package assign07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * This class represents a graph data structure, which holds vertex objects and
 * connections via edges
 * 
 * 
 * @author Lune Holliman & Ryan Powell
 * @version Oct 29 2026
 */

public class Graph<Type> {
	private Map<Type, Vertex<Type>> vertices;

	public Graph() {
		vertices = new HashMap<>();
	}

	/**
	 * Connects two vertices with an Edge object
	 * 
	 * @param source      - source vertex
	 * @param destination - destination vertex
	 * @param weight      - weight of edge
	 */
	public void addEdge(Type source, Type destination, double weight) {
		addVertex(source);
		addVertex(destination);
		Vertex<Type> SourceVertex = vertices.get(source);
		Vertex<Type> DestinationVertex = vertices.get(destination);
		SourceVertex.addEdge(DestinationVertex, weight);
	}

	/**
	 * Creates a new Vertex object
	 * 
	 * @param data - to be stored in a new Vertex
	 */
	public void addVertex(Type data) {
		if (!vertices.containsKey(data))
			vertices.put(data, new Vertex<>(data));
	}

	/**
	 * Finds the shortest unweighted path between two items in a Graph
	 * 
	 * @param source      - source vertex
	 * @param destination - destination vertex
	 * @return - shortest weighted path from source to destination
	 */
	public List<Type> breadthFirstSearch(Type source, Type destination) {
		if (!vertices.containsKey(source) || !vertices.containsKey(destination))
			throw new IllegalArgumentException();
		for (Vertex<Type> v : vertices.values()) {
			v.distance = Double.MAX_VALUE;
			v.previous = null;
		}
		Queue<Vertex<Type>> queue = new LinkedList<>();
		Vertex<Type> first = vertices.get(source);
		first.distance = 0.0;
		queue.offer(first);
		boolean reached = false;
		while (!queue.isEmpty()) {
			Vertex<Type> tempVertex = queue.poll();
			if (tempVertex.data.equals(destination)) {
				reached = true;
				break;
			}
			for (Edge<Type> e : tempVertex.adj) {
				Vertex<Type> neighbor = e.destination;
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
			throw new IllegalArgumentException();
		while (destinationVertex != null) {
			returnList.add(destinationVertex.data);
			destinationVertex = destinationVertex.previous;
		}
		Collections.reverse(returnList);
		return returnList;
	}

	/**
	 * Finds the shortest weighted path between two items in a Graph using Dijkstras
	 * Algorithm
	 * 
	 * @param source      - source vertex
	 * @param destination - destination vertex
	 * @return shortest weighted path from source to destination
	 */
	public List<Type> dijkstrasAlgorithm(Type source, Type destination) {
		if (!vertices.containsKey(source) || !vertices.containsKey(destination))
			throw new IllegalArgumentException();
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
				Vertex<Type> neighbor = e.destination;
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
			returnList.add(curr.data);
			curr = curr.previous;
		}
		Collections.reverse(returnList);
		return returnList;
	}

	/**
	 * Topological sort is a linear ordering of vertices, in a acylic directed graph
	 * where each edge is directed, and the vertex u comes before vertex V (u -> v)
	 * 
	 * @return sorted ordering of vertices
	 */
	public List<Type> topoSort() {
		for (Vertex<Type> v : vertices.values())
			v.indegree = 0;
		for (Vertex<Type> v : vertices.values())
			for (Edge<Type> edge : v.adj)
				edge.destination.indegree++;

		Queue<Vertex<Type>> queue = new LinkedList<>();
		for (Vertex<Type> v : vertices.values())
			if (v.indegree == 0)
				queue.add(v);
		List<Type> sortedList = new ArrayList<>();
		while (!queue.isEmpty()) {
			Vertex<Type> current = queue.poll();
			sortedList.add(current.data);
			for (Edge<Type> edge : current.adj) {
				Vertex<Type> neighbor = edge.destination;
				neighbor.indegree--;
				if (neighbor.indegree == 0)
					queue.add(neighbor);
			}
		}
		if (sortedList.size() != vertices.size())
			throw new IllegalArgumentException();
		return sortedList;

	}
}
