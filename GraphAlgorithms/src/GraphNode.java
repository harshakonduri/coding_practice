
public class GraphNode {
private String name;
private int d;
private int f;
private GraphNode parent;
private String color;
public GraphNode(String name) {
	this.name = name;
	d = -1;
	f = -1;
	parent = null;	
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
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public boolean equals(Object obj) {
	if(obj instanceof GraphNode && ((GraphNode) obj).getName().equals(name)) {
		return true;
	}
	return false;
}
}
