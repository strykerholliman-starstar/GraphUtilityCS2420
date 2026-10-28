package assign07;

import java.util.Comparator;

public class CompareByDistFromStartReverse<Type> implements Comparator<Vertex<Type>> {

	@Override
	public int compare(Vertex<Type> o1, Vertex<Type> o2) {

		return (int) (o2.distance - o1.distance);
	}

}