import java.util.Comparator;
public class GraphNodeComparator implements Comparator<GraphNode> {
    public int compare(GraphNode g1,GraphNode g2) {
	if(g1.getWeight() < g2.getWeight()) {
	    return -1;
	}
	else if(g1.getWeight() == g2.getWeight()) {
	    return 0;
	}
	else {
	    return 1;
	}
    }
}