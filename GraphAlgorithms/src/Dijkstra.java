import java.util.PriorityQueue;
import java.util.Set;
public class Dijkstra {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Graph g = new Graph("AL",true);
	    g.addEdge("a", "b",5);
	    g.addEdge("a", "c",2);
	    g.addEdge("b", "d",3);
	    g.addEdge("c", "d",2);
	    g.addEdge("d", "e",1);
	    g.addEdge("b", "c",1);
	    dijkstraSP(g,g.getVertex("a"));
	}
    static void dijkstraSP(Graph g,GraphNode source) {
	PriorityQueue<GraphNode> pq = new PriorityQueue<GraphNode>(g.getV(),
								   new GraphNodeComparator());
	Set<GraphNode> verticies = g.vertexSet();
	for(GraphNode vertex:verticies) {
	    if(vertex.equals(source)) {
		vertex.setWeight(0);
	    }
	    pq.add(vertex);
	}
	while(pq.size() > 0) {
	    GraphNode min = pq.poll();
	    for(Edge e:min.getEdgeList()) {
		relax(min,e);
	    }
	    System.out.println("Extracted Node is "+min.toString());
	}
    }
    static void relax(GraphNode s,Edge e) {
	GraphNode dest = e.getDest();
	if(dest.getWeight() < s.getWeight()+e.getWeight()) {
	    dest.setWeight(s.getWeight()+e.getWeight());
	    dest.setParent(s);
	}
    }
}
