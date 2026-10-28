package assign07;

import java.util.Comparator;

/**
 * @author  Lune Holliman and Ryan Powell
 * @version Oct 23 2026
 */

public class CompareByDistFromStartReverse<Type> implements Comparator<Vertex<Type>> {

	@Override
	public int compare(Vertex<Type> o1, Vertex<Type> o2) {

		return (int) (o2.distance - o1.distance);
	}

}