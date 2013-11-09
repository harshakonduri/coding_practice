
public class DummyNode {
public String value;
public DummyNode(String value) {
	this.value = value;
}
public int hashCode() {
	int hc = value.length();
	return hc;
}
public boolean equals(Object o) {
	if(o instanceof DummyNode && ((DummyNode) o).value == value) {
		return true;
	}
	return false;
}
}
