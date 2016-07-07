import java.util.Arrays;

public class Graph {

	public static int noOfVertex;

	public int noOfEdge;

	/**
	 * For each Edge we will have source and destination and weight
	 */
	public Edge[] edges;

	class Edge implements Comparable<Edge> {

		int src, dest, weight;

		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		public Edge() {
			super();
		}

		@Override
		public int compareTo(Edge o) {
			if (o.weight < this.weight) {
				return 1;
			} else
				return -1;
		}

	};

	class Subset {
		int parent, rank;

		public Subset(int parent, int rank) {
			this.parent = parent;
			this.rank = rank;
		}

	};

	public Graph(int V, int E) {
		this.noOfVertex = V;
		this.noOfEdge = E;
		this.edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			edges[i] = new Edge();
		}
	}

	public static void main(String[] args) {
		//
		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// int e = sc.nextInt();
		Graph graph = new Graph(4, 5);
		graph.edges[0].src = 0;
		graph.edges[0].dest = 1;
		graph.edges[0].weight = 10;

		// add edge 0-2
		graph.edges[1].src = 0;
		graph.edges[1].dest = 2;
		graph.edges[1].weight = 6;

		// add edge 0-3
		graph.edges[2].src = 0;
		graph.edges[2].dest = 3;
		graph.edges[2].weight = 5;

		// add edge 1-3
		graph.edges[3].src = 1;
		graph.edges[3].dest = 3;
		graph.edges[3].weight = 15;

		// add edge 2-3
		graph.edges[4].src = 2;
		graph.edges[4].dest = 3;
		graph.edges[4].weight = 4;

		/*
		 * for (int i = 0; i < e; i++) { graph.edges[i].src = -1;
		 * graph.edges[i].dest = -1; graph.edges[i].weight = Integer.MAX_VALUE;
		 * }
		 */
		//
		// for (int i = 0; i < n; i++) {
		// int src = sc.nextInt();
		// int dest = sc.nextInt();
		// int weight = sc.nextInt();
		// graph.edges[i].src = src;
		// graph.edges[i].dest = dest;
		// graph.edges[i].weight = weight;
		// }
		Arrays.sort(graph.edges);
		graph.KusrshalAlgo(graph.edges);

	}

	public void KusrshalAlgo(Edge[] edges2) {
		// Create E subset and whenever creating new Edge mere it into this
		// subset and checks if
		// this leads to create loop or not
		// Will create loop if both subset has same parent
		// Make every node to it's parent
		Subset sets[] = new Subset[noOfVertex];
		Edge[] result = new Edge[noOfVertex];

		for (int i = 0; i < noOfVertex; i++) {
			sets[i] = new Subset(i, 0);
			result[i] = new Edge();
		}

		int i = 0;
		int ee = 0;
		while (i <= noOfVertex - 1) {
			Edge edge = new Edge();
			edge = edges2[i++];
			int rootX = findParent(edge.src, sets);
			int rootY = findParent(edge.dest, sets);
			if (rootX == rootY)
				continue;
			else {
				result[ee++] = edge;
				merge(sets, rootX, rootY);
			}
		}
		System.out.println("Following are the edges in the constructed MST");
		for (i = 0; i < noOfVertex; ++i)
			System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);

	}

	public int findParent(int child, Subset[] sets) {
		if (sets[child].parent == child) {
			return child;
		}
		return sets[child].parent = findParent(sets[child].parent, sets);
	}

	public void merge(Subset[] sets, int a, int b) {
		int rootA = findParent(a, sets);
		int rootB = findParent(b, sets);
		if (sets[rootA].rank < sets[rootB].rank) {
			sets[rootA].parent = rootB;
		}

		else if (sets[rootA].rank > sets[rootB].rank) {
			sets[rootB].parent = rootA;
		}

		else {
			sets[rootB].parent = rootA;
			sets[rootA].rank++;
		}
	}

}
