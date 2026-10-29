package assign07;

import java.util.Comparator;

/**
 * @author Lune Holliman and Ryan Powell
 * @version Oct 23 2026
 */

public class CompareByDistFromStartReverse<Type> implements Comparator<Vertex<Type>> {

	@Override
	public int compare(Vertex<Type> o1, Vertex<Type> o2) {
		if (o2.distance > o1.distance)
			return -1;
		if (o2.distance < o1.distance)
			return 1;
		return 0;
	}

}