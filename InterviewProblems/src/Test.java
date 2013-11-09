import java.util.HashMap;


public class Test {
static HashMap<DummyNode,String> m = new HashMap<DummyNode, String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
DummyNode d1 = new DummyNode("Hello");
m.put(d1, "Hello Hi");
System.out.println(m.get(new DummyNode("Hello")));

	}

}
