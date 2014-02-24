import java.util.Set;
import java.util.ArrayList;
public class BellmanFord {
    public static void main(String[] args) {
	Graph g = new Graph("AL",true);// create a directedGraph
	g.addEdge("a", "b",-2);
	g.addEdge("c", "a",-3);
	g.addEdge("b", "c",-1);
	//	g.addEdge("c","b",-2);
	//	g.addEdge("d", "c",-2);
	bellmanford(g);
    }
    static boolean bellmanford(Graph g) {
	Set<GraphNode> vertexSet = g.vertexSet();
	for(int i = 0;i<vertexSet.size();i++) {
	    for(GraphNode u : vertexSet) {
		ArrayList<Edge> edgeSet = u.getEdgeList();
		for(Edge e : edgeSet) {
		    relax(u,e);
		}//relax adjacent edges of a vertex
	    }// relax all edges in graph
	}//repeat process V times
	boolean b =  hasNegCycle(g);
	if(b) {
	    System.out.println("There is a Neg Cycle");
	}
	else {
	    System.out.println("There is no Neg Cycle");
	}
	return b;
    }
    static void relax(GraphNode u, Edge e) {
	GraphNode v = e.getDest();
	if(v.getWeight() > u.getWeight() + e.getWeight()) {
	    v.setWeight(u.getWeight() + e.getWeight());
	    v.setParent(u);
	}
    }
    static boolean hasNegCycle(Graph g) {
	Set<GraphNode> vs = g.vertexSet();
	for(GraphNode u : vs) {
	    ArrayList<Edge> edgeSet = u.getEdgeList();
	    for(Edge e : edgeSet) {
		GraphNode v = e.getDest();
		if(v.getWeight() > u.getWeight() + e.getWeight()) {
		    return true;
		}
	    }
	}
	return false;
    }
}