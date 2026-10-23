package assign07;

import java.util.*;

/**
 *  
 * 
 * 
 * @author Lune Holliman &  Ryan Powell
 * @version Oct 23 2026
 */

public class Graph<Type> {
	private List<Vertex<Type>> vertices;
	
	public Graph() {
		vertices = new ArrayList<>();
	}
	
	public Vertex<Type> getVertex(Type data) {
		for (Vertex<Type> v : vertices) {
			if (v.getData().equals(data)) {
				return v;
			}
		}
		return null;
	}
	
	public List<Type> breadthFirstSearch(Type source, Type destination) {
		
	}
	
	public List<Type> dijkstrasAlgorithm(Type source, Type destination)    {
		
	}
	
	public List<Type> topoSort() {
		
	}
}
