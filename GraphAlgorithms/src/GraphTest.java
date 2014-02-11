
public class GraphTest {

	public static void main(String[] args) {

		Graph g = new Graph("AL");
		g.addEdge("a", "b");
		g.addEdge("a", "c");
		g.addEdge("b", "d");
		g.addEdge("c", "d");
		g.displayGraph();
	}

}
