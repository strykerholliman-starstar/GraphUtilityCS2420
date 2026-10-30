package assign07;

import java.util.List;

/**
 * This class contains driver methods to be used with graphs including Breadth
 * First Search, Dijkstras Algorithm, and Topological sort.
 * 
 * 
 * @author Lune Holliman & Ryan Powell
 * @version Oct 29 2026
 */

public class GraphUtility {

	/**
	 * Finds the shortest unweighted path between two items in a Graph using Breadth
	 * First Search
	 *
	 * 
	 * @param <Type>       - type of element stored in vertices.
	 * @param sources      - source vertices
	 * @param destinations - destination vertices
	 * @param srcData      - starting vertex
	 * @param dstData      - destination vertex
	 * @return shortest path of elements from src to dst
	 */

	public static <Type> List<Type> shortestPath(List<Type> sources, List<Type> destinations, Type srcData,
			Type dstData) {
		if (sources.size() != destinations.size())
			throw new IllegalArgumentException();
		Graph<Type> graph = new Graph<>();
		for (int i = 0; i < sources.size(); i++)
			graph.addEdge(sources.get(i), destinations.get(i), 1.0);
		return graph.breadthFirstSearch(srcData, dstData);
	}

	/**
	 * Finds the shortest weighted path between two items in a Graph using Dijkstras
	 * Algorithm
	 *
	 * 
	 * @param <Type>       - type of element stored in vertices.
	 * @param sources      - source vertices
	 * @param destinations - destination vertices
	 * @param weights      - weights of edges
	 * @param srcData      - starting vertex
	 * @param dstData      - destination vertex
	 * @return a graph going under dijkstras algortihm
	 */
	public static <Type> List<Type> shortestWeightedPath(List<Type> sources, List<Type> destinations,
			List<Double> weights, Type srcData, Type dstData) {
		if (sources.size() != destinations.size() || sources.size() != weights.size())
			throw new IllegalArgumentException();
		Graph<Type> graph = new Graph<>();
		for (int i = 0; i < sources.size(); i++)
			graph.addEdge(sources.get(i), destinations.get(i), weights.get(i));
		return graph.dijkstrasAlgorithm(srcData, dstData);
	}

	/**
	 * Sorts the two given lists in a topological ordering
	 * 
	 * @param <Type>       - type of element stored in vertices.
	 * @param sources      - source vertices
	 * @param destinations - destination vertices
	 * @return - topologically sorted list
	 */
	public static <Type> List<Type> sort(List<Type> sources, List<Type> destinations) {
		if (sources.size() != destinations.size())
			throw new IllegalArgumentException();
		Graph<Type> graph = buildGraph(sources, destinations);
		return graph.topoSort();
	}

	/**
	 * Helper method to create and fill a graph with two given lists
	 * 
	 * @param <T>         - type of element stored in vertices.
	 * @param sources     - source vertices
	 * @param destination - destination vertices
	 * @return built graph
	 */
	private static <T> Graph<T> buildGraph(List<T> sources, List<T> destination) {
		Graph<T> graph = new Graph<>();
		for (int i = 0; i < sources.size(); i++)
			graph.addEdge(sources.get(i), destination.get(i), 1.0);
		return graph;
	}
}
