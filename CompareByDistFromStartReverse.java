package assign07;

import java.util.Comparator;

/**
 * Defines a custom comparison for vertices, using distance.
 * 
 * @author Lune Holliman and Ryan Powell
 * @version Oct 29 2026
 */

public class CompareByDistFromStartReverse<Type> implements Comparator<Vertex<Type>> {
	/**
	 * Compares two vertices, using distance
	 * 
	 * @param o1 - one vertex being compared
	 * @param 02 - one vertex being compared.
	 * 
	 * @return positive integer if the first Vertex's distance is smaller, negative
	 *         integer if the first Vertex's distance is larger, 0 if the distance
	 *         is the same
	 * 
	 */
	@Override
	public int compare(Vertex<Type> o1, Vertex<Type> o2) {
		if (o2.distance > o1.distance)
			return 1;
		if (o2.distance < o1.distance)
			return -1;
		return 0;
	}

}