package assign07;

import java.util.Comparator;

/**
 * compares by distance of two vertices into the method
 * 
 * @author Lune Holliman and Ryan Powell
 * @version Oct 23 2026
 */

public class CompareByDistFromStartReverse<Type> implements Comparator<Vertex<Type>> {
	/**
	 * compares two vertices
	 * 
	 * @param o1 - one vertex being compared
	 * @param 02 - one vertex being compared.
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