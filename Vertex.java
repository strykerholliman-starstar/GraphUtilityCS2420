package assign07;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *  
 * 
 * 
 * @author Lune Holliman &  Ryan Powell
 * @version Oct 23 2026
 */

public class Vertex<T> {
	
	
	private T name;
	
	private LinkedList<Edge<T>> adj;
	public int indegree;

}
