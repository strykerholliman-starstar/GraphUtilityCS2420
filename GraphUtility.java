package assign07;

import java.util.*;

/**
 * this class contains methods for checking the shortest path for different
 * graphs, testing each search, with BFS, Dijkstras, and TOpo sort, it also
 * builds a grpah for them.
 * 
 * 
 * @author Lune Holliman & Ryan Powell
 * @version Oct 23 2026
 */

public class GraphUtility {

	/**
	 * This class uses BFS to return the graph after getting the sources and
	 * destinations into a graph as vertexs and edges.
	 * 
	 * @param <Type>
	 * @param sources
	 * @param destinations
	 * @param srcData
	 * @param dstData
	 * @return it returns the graph after being done with BFS
	 */

	public static <Type> List<Type> shortestPath(List<Type> sources, List<Type> destinations, Type srcData,
			Type dstData) {
		if (sources.size() != destinations.size()) {
			throw new IllegalArgumentException("Soruces and destinations must be equal sizes.");
		}
		Graph<Type> graph = new Graph<>();
		for (int i = 0; i < sources.size(); i++) {
			graph.addEdge(sources.get(i), destinations.get(i), 1.0);
		}
		return graph.breadthFirstSearch(srcData, dstData);
	}

	public static <Type> List<Type> shortestWeightedPath(List<Type> sources, List<Type> destinations,
			List<Double> weights, Type srcData, Type dstData) {
		if (sources.size() != destinations.size() || sources.size() != weights.size())
			throw new IllegalArgumentException("Sources and destinations must be equal sizes.");
		Graph<Type> graph = new Graph<>();
		for (int i = 0; i < sources.size(); i++)
			graph.addEdge(sources.get(i), destinations.get(i), weights.get(i));

		return graph.dijkstrasAlgorithm(srcData, dstData);
	}

	public static <Type> List<Type> sort(List<Type> sources, List<Type> destinations) {
		if (sources.size() != destinations.size())
			throw new IllegalArgumentException("Soruces and destinations must be equal sizes.");
		Graph<Type> graph = buildGraph(sources, destinations);
		return graph.topoSort();
	}

	private static <T> Graph<T> buildGraph(List<T> sources, List<T> destination) {
		Graph<T> graph = new Graph<>();
		for (int i = 0; i < sources.size(); i++) {
			T src = sources.get(i);
			T des = destination.get(i);
			graph.addEdge(src, des, 1.0);
		}
		return graph;
	}
}
