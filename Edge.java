package assign07;

/**
 *  
 * 
 * 
 * @author Lune Holliman &  Ryan Powell
 * @version Oct 23 2026
 */

public class Edge<T> {
	private Vertex<T> destination;
	public double weight;
	
	
	public Edge(Vertex<T> destination, double weight) {
		this.weight = weight;
		this.destination = destination;
	}
	
	
	
	public Vertex<T> getDestination() {
		return this.destination;
	}
	
	public double getWeight() {
		return weight;
	}
	
	
	
	
	
	

}
