import java.util.ArrayList;

public class problem7 {

	public static void main(String [] args) {
		ArrayList<Integer> h = new ArrayList<Integer>();
		h.add(2);
		h.add(3);
		h.add(5);
		int i = 7;
		while(true) {
			boolean b = false;
			if(h.size() > 10000) {
				 System.out.println(h.get(10000));
				 return;
			}
			for(int l:h) {
				if(i%l == 0) {
					b = true;
					break;
				}
			}
			if(!b)
				h.add(i);
			//System.out.println(h);
			i = i + 2;
		}
	}
}
