import java.util.Stack;
    public class Tower {
	java.util.Stack<Integer> disk;
	public Tower() {
	    disk = new Stack<Integer>();
	}
	public boolean add(int i) {
	    if(disk.size() <=0 || disk.peek() < i) {
		disk.push(i);
		return true;
	    }
	    return false;
	}
	public void moveTopDisk(Tower destination) {
	    if(destination.disk.size() <=0 || disk.size() > 0 || destination.disk.peek() < disk.peek() ) {
		destination.disk.push(disk.pop());
	    }
	}
	public void moveDisks(int n,Tower dest,Tower buff) {
	    if(n>0) {
		moveDisks(n-1,buff,dest);
		moveTopDisk(dest);
		buff.moveDisks(n-1,dest,this);
	    }
	}
    }
