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
	 * @param <Type>       - the type of elements that are in the vertices.
	 * @param sources      - source vertexs
	 * @param destinations - destinations vertices
	 * @param srcData      - the names of the source
	 * @param dstData      - name of the destination
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

	/**
	 * does the dijkstra algorithim with making a new grpah with the sources and
	 * destination.
	 * 
	 * @param <Type>
	 * @param sources      - the sources for each edge
	 * @param destinations - the destiantions for each edge.
	 * @param weights      - the weights
	 * @param srcData      - the source name
	 * @param dstData      - the destination name
	 * @return - returns a graph going under dijkstras algortihm
	 */
	public static <Type> List<Type> shortestWeightedPath(List<Type> sources, List<Type> destinations,
			List<Double> weights, Type srcData, Type dstData) {
		if (sources.size() != destinations.size() || sources.size() != weights.size())
			throw new IllegalArgumentException("Sources and destinations must be equal sizes.");
		Graph<Type> graph = new Graph<>();
		for (int i = 0; i < sources.size(); i++)
			graph.addEdge(sources.get(i), destinations.get(i), weights.get(i));

		return graph.dijkstrasAlgorithm(srcData, dstData);
	}

	/**
	 * makes a graph and uses topo sort on it
	 * 
	 * @param <Type>       the data type of the elements stored at each vertex
	 * @param sources      - the starting vertex for each directed edge
	 * @param destinations - the ending vertex for each edge
	 * @return - returns the graph where topo sort is done
	 */
	public static <Type> List<Type> sort(List<Type> sources, List<Type> destinations) {
		if (sources.size() != destinations.size())
			throw new IllegalArgumentException("Soruces and destinations must be equal sizes.");
		Graph<Type> graph = buildGraph(sources, destinations);
		return graph.topoSort();
	}

	/**
	 * builds a graph using the sources and destination lists.
	 * 
	 * @param <T>         the type of elements at the vertexs
	 * @param sources     - the list that the edges come from, soruce vertices
	 * @param destination - the list that the edges go to, destination vertices.
	 * @return - returns the made graph.
	 */
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
