package assign07;

/**
 * This class represents an Edge of a vertex, storing the destination and weight
 * to travel to such destination *
 * 
 * @author Lune Holliman & Ryan Powell
 * @version Oct 29 2026
 */

public class Edge<T> {
	public Vertex<T> destination;
	public double weight;

	/**
	 * Constructs the Edge
	 * 
	 * @param destination - desintation vertex
	 * @param weight      - weight of traversal
	 */
	public Edge(Vertex<T> destination, double weight) {
		this.weight = weight;
		this.destination = destination;
	}
}
