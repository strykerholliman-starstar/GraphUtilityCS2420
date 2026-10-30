package assign07;

/**
 * This is the class to track the Edges, it tracks its weight and its
 * destination, and it has two methods talking about the destination and weight.
 * 
 * 
 * @author Lune Holliman & Ryan Powell
 * @version Oct 23 2026
 */

public class Edge<T> {
	private Vertex<T> destination;
	public double weight;

	/**
	 * initates the edge
	 * 
	 * @param destination - the desintation vertex
	 * @param weight      - the weight of the edge
	 */
	public Edge(Vertex<T> destination, double weight) {
		this.weight = weight;
		this.destination = destination;
	}

	/**
	 * returns the destination of the edge
	 * 
	 * @return - rethrns the destination
	 */
	public Vertex<T> getDestination() {
		return this.destination;
	}

	/**
	 * gets the weight
	 * 
	 * @return - the weight
	 */
	public double getWeight() {
		return weight;
	}

}
