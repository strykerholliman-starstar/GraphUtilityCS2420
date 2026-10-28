package assign07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph<Type> {
	private HashMap<Type, Vertex<Type>> vertices;

	public Graph(List<Type> sources, List<Type> destinations) {
		vertices = new HashMap<>();
	}

	public void addEdge(Type source, Type destination, double weight) {

		// Code from lecture
		Vertex<Type> srcVertex;
		if (vertices.containsKey(source))
			srcVertex = vertices.get(source);
		else {
			srcVertex = new Vertex<Type>(source);
			vertices.put(source, srcVertex);
		}

		Vertex<Type> dstVertex;
		if (vertices.containsKey(destination))
			dstVertex = vertices.get(destination);
		else {
			dstVertex = new Vertex<Type>(destination);
			vertices.put(destination, dstVertex);
		}
		srcVertex.addEdge(dstVertex, weight);
	}

	public List<Type> breadthFirstSearch(Type source, Type destination) {
		Queue<Vertex<Type>> queue = new LinkedList<>();
		queue.offer(vertices.get(source));
		Vertex<Type> tempVertex = queue.peek();
		while (!queue.isEmpty()) {
			tempVertex = queue.poll();
			for (Edge<Type> e : tempVertex.adj) {
				if (e.getDestination().distance == 0.0) {
					e.getDestination().distance = tempVertex.distance + 1.0;
					e.getDestination().previous = tempVertex;
					queue.offer(e.getDestination());
				}
			}
			if (tempVertex.data.equals(destination))
				break;
		}
		List<Type> returnList = new ArrayList<>();
		returnList.add(tempVertex.data);
		while (tempVertex.previous != null) {
			tempVertex = tempVertex.previous;
			returnList.add(tempVertex.data);
		}
		return returnList;
	}

	public List<Type> dijkstrasAlgorithm(Type source, Type destination) {
		Vertex<Type> tempVertex;
		ArrayList<Vertex<Type>> removeList = new ArrayList<>();
		removeList.addAll(vertices.values());
		while (!removeList.isEmpty())
			removeList.sort(new CompareByDistFromStartReverse<Type>());
		tempVertex = removeList.getLast();
		for (Edge<Type> e : tempVertex.adj) {
			if (tempVertex.distance + e.weight < e.getDestination().distance) {
				e.getDestination().distance = tempVertex.distance + e.weight;
				e.getDestination().previous = tempVertex;
			}
			removeList.removeLast();
		}
		tempVertex = vertices.get(destination);

		ArrayList<Type> returnList = new ArrayList<>();

		while (tempVertex != null) {
			returnList.add(tempVertex.data);
			tempVertex = tempVertex.previous;
		}
		return returnList;
	}

	public List<Type> topoSort() {
		return null;
	}
}
