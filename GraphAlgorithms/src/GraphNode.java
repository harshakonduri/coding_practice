import java.util.ArrayList;
public class GraphNode {
    private String name;
    private int d;
    private int f;
    private int weight;
    private GraphNode parent;
    private String color;
    private ArrayList<Edge> adjacentEdges;
    public GraphNode(String name) {
	this.name = name;
	d = -1;
	f = -1;
	parent = null;	
	color = "WHITE";
	weight = Integer.MAX_VALUE;
	adjacentEdges = new ArrayList<Edge>();
    }
    public void addEdge(Edge e) {
	adjacentEdges.add(e);
    }
    public void removeEdge(Edge e) {
	if(null == e) {
	    return;
	}
	adjacentEdges.remove(e);
    }
    public void removeEdge(GraphNode s,GraphNode v) {
	removeEdge(getEdge(s,v));
    }
    public Edge getEdge(GraphNode s,GraphNode v) {
	for(Edge e : adjacentEdges) {
	    if(((e.getSource()).equals(s)) && ((e.getDest()).equals(v))) {
		return e;
	    }
	}
	return null;
    }
    public ArrayList<Edge> getEdgeList() {
	return adjacentEdges;
    }
    public String getName() {
	return name;
    }
    public void setName(String name) {
	this.name = name;
    }
    public int getD() {
	return d;
    }
    public void setD(int d) {
	this.d = d;
    }
    public int getF() {
	return f;
    }
    public void setF(int f) {
	this.f = f;
    }
    public GraphNode getParent() {
	return parent;
    }
    public void setParent(GraphNode parent) {
	this.parent = parent;
    }
    public void setWeight(int w) {
	weight = w;
    }
    public int getWeight() {
	return weight;
    }
    public String getColor() {
	return color;
    }
    public void setColor(String color) {
	this.color = color;
    }
    public String toString() {
	return this.name;
    }
    public boolean equals(Object obj) {
	if(obj instanceof GraphNode && ((GraphNode) obj).getName().equals(name)) {
	    return true;
	}
	return false;
    }
}
