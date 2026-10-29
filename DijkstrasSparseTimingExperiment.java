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
public class DijkstrasSparseTimingExperiment extends TimingExperiment {
	private static String problemSizeDescription = "vertexCount";
	private static int problemSizeMin = 10000;
	private static int problemSizeCount = 11;
	private static int problemSizeStep = 10000;
	private static int experimentIterationCount = 100;
	private int problemSizebutforme;

	private static final Random rng = new Random();
	private Graph<Integer> acyclicRandomGraph;

	public static void main(String[] args) {
		TimingExperiment timingExperiment = new DijkstrasSparseTimingExperiment();
		timingExperiment.printResults();
	}

	public DijkstrasSparseTimingExperiment() {
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

		for (int i = 0; i < problemSize; i++) {
			acyclicRandomGraph.addEdge(i, i + 1, rng.nextDouble(15.0));
			acyclicRandomGraph.addEdge(i, rng.nextInt(i + 1, problemSize + 1), rng.nextDouble(15));
		}

		problemSizebutforme = problemSize;

	}

	/**
	 * Run the topoSort method.
	 */
	protected void runComputation() {
		acyclicRandomGraph.dijkstrasAlgorithm(1, problemSizebutforme);
	}
}