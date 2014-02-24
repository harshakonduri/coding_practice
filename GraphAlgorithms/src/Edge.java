public class Edge {
   private int weight;
   private GraphNode source;
   private GraphNode dest;
    public Edge(GraphNode s,GraphNode v) {
	source = s;
	dest = v;
	weight = 1;
    }
    public Edge(GraphNode s,GraphNode v,int w) {
	source = s;
	dest = v;
	weight = w;
    }
    public void setWeight(int w) {
	weight = w;
    }
    public int getWeight() {
	return weight;
    }
    public void setSource(GraphNode s) {
	source = s;
    }
    public GraphNode getSource() {
	return source;
    }
    public void setDest(GraphNode v) {
	dest = v;
    }
    public GraphNode getDest() {
	return dest;
    }
}