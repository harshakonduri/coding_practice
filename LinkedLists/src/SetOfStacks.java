import java.util.*;
public class SetOfStacks {
    ArrayList<Stacks> set;
    int capacity;
    int stackIndex;
    public SetOfStacks(int c) {
	set = new ArrayList<Stacks>();
	capacity = c;
	stackIndex = 0;
	set.add(new Stacks());
    }
    public void push(int i) {
	Stacks s = set.get(stackIndex);
	if(s.getSize() == capacity) {
	set.add(new Stacks());
	stackIndex++;
	s = set.get(stackIndex);
	}
	s.push(i);	
    }
    public Node pop() { 	
    Stacks s  = set.get(stackIndex);
    System.out.println(stackIndex+" "+s.getSize());
    if(0 == s.getSize() && stackIndex > 0) {
	set.remove(stackIndex);
	stackIndex--;
	System.out.println(stackIndex);
	s = set.get(stackIndex);
    }
    if(s.getSize() > 0){
	Node t = s.pop();
	return t;
	}
    else {
    	set.remove(stackIndex);
    	stackIndex--;
    	System.out.println(stackIndex);
    	s = set.get(stackIndex);
    	return s.pop();
    }
    }
}
