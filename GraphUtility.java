package assign07;

import java.util.*

/**
 *  
 * 
 * 
 * @author Lune Holliman &  Ryan Powell
 * @version Oct 23 2026
 */

public class GraphUtility {

	
	
	
	public static <Type> List<Type> shortestPath(List<Type> sources, List<Type> destinations, Type srcData, Type dstData) {
		if(sources.size() != destinations.size()) {
			throw new IllegalArgumentException("Soruces and destinations must be equal sizes.");
		}
		
	}
	
	public static <Type> List<Type> shortestWeightedPath(List<Type> sources, List<Type> destinations, List<Double> weights, Type srcData, Type dstData) {
		if (sources.size() != destinations.size() || sources.size() != weights.size()) {
			throw new IllegalArgumentException("Sources and destinations must be equal sizes.");
		}
	}
	
	public static <Type> List<Type> sort(List<Type> sources, List<Type> destinations)   {
		if(sources.size() != destinations.size()) {
			throw new IllegalArgumentException("Soruces and destinations must be equal sizes.");
		}
	}
}

