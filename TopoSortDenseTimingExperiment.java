package assign07;

import java.util.Random;

import timing.TimingExperiment;

/**
 * Experiment to measure the running time of topological sort for random acyclic
 * sparse graphs with a range of vertex counts.
 *
 * @author CS 2420 course staff
 * @version October 8, 2026
 */
public class TopoSortDenseTimingExperiment extends TimingExperiment {
	private static String problemSizeDescription = "vertexCount";
	private static int problemSizeMin = 5000;
	private static int problemSizeCount = 11;
	private static int problemSizeStep = 1000;
	private static int experimentIterationCount = 100;

	private static final Random rng = new Random();
	private Graph<Integer> acyclicRandomGraph;

	public static void main(String[] args) {
		TimingExperiment timingExperiment = new TopoSortDenseTimingExperiment();
		timingExperiment.printResults();
	}

	public TopoSortDenseTimingExperiment() {
		super(problemSizeDescription, problemSizeMin, problemSizeCount, problemSizeStep, experimentIterationCount);
	}

	/**
	 * Setup experiment for problemSize by generating a sparse acyclic random graph.
	 * 
	 * @param problemSize - number of vertices
	 */
	protected void setupExperiment(int problemSize) {
		// V = {0, 1, ..., problemSize - 1}
		acyclicRandomGraph = new Graph<Integer>();

		// |E| = 2 * problemSize
		for (int i = 0; i < problemSize; i++)
			for (int j = i + 1; j < problemSize + 1; j++)
				acyclicRandomGraph.addEdge(i, j, 0.0);
	}

	/**
	 * Run the topoSort method.
	 */
	protected void runComputation() {
		acyclicRandomGraph.topoSort();
	}
}