import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class GuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
	BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
	String s = br.readLine();
	int testcases = Integer.parseInt(s);
		for(int t = 1;t <= testcases;++t) {
			s = br.readLine();
			int cases = Integer.parseInt(s);
		//	System.out.println(cases+" "+t);
			ConcurrentHashMap<Range, Integer> map = new ConcurrentHashMap<Range, Integer>();
			for(int c = 1;c <= cases;++c) {
				s = br.readLine();
				boolean isequals = false;
				String [] st = s.split(" ");
				int val = Integer.parseInt(st[1]);
				
				Range r1=null,r2 = null;
				
				if(st[2].equals("No")) {
					if(st[0].equals("=")) {
						isequals = true;
						r1 = new Range(Integer.MIN_VALUE,val-1);
						r2 = new Range(val+1,Integer.MAX_VALUE);
					}
					else if(st[0].equals("<")) {
						r1 = new Range(val,Integer.MAX_VALUE);
					}
					else if(st[0].equals(">")) {
						r1 = new Range(Integer.MIN_VALUE, val);
					}
				} else {
					if(st[0].equals("=")) {
						r1 = new Range(val,val);
					}
					else if(st[0].equals(">")) {
						r1 = new Range(val+1,Integer.MAX_VALUE);
					}
					else if(st[0].equals("<")) {
						r1 = new Range(Integer.MIN_VALUE, val-1);
					}
				}
				if(isequals) {
					if(map.size() == 0) {
						map.put(r1, 1);
						map.put(r2, 1);
					}
					else {
						Set<Range> keys = map.keySet();
						for(Range r : keys) {
							if(r.equals(r1)) {
							//	System.out.println("Range equals");
								int v = map.get(r);
								map.remove(r);
								map.put(r, v+1);
							}
							else if(r.inRange(r1)) {
							//	System.out.println("Range overlap");
								int v = map.get(r);
								map.remove(r);
								map.put(r, v+1);
								map.put(r1, 1);
								
							}
							else if( r.inRange(r2)) {
								int v = map.get(r);
								map.remove(r);
								map.put(r, v+1);								
								map.put(r2, 1);
							}
							else {
								map.put(r1, 1);
								map.put(r2, 1);
							}
						}
					}
				}
				else {
					if(map.size() == 0) {
						map.put(r1, 1);
					}
					else {
						Set<Range> keys = map.keySet();
						Iterator<Range> it = keys.iterator();
						while(it.hasNext()) {
							Range r = it.next();
							if(r1.equals(r)) {
							//	System.out.println("Range equals");
								int v = map.get(r);
								map.remove(r);
								map.put(r, v+1);
							}
							else if(r.inRange(r1)) {
							//	System.out.println("Range overlap");
								int v = map.get(r);
								map.remove(r);
								map.put(r, v+1);
								map.put(r1, 1);
							}
							else {
								map.put(r1, 1);
							}
						}
					}
				}
				
			}
			Integer [] a = new Integer[map.values().size()];
			a = map.values().toArray(a);
			Arrays.sort(a);
			System.out.println(cases - a[a.length-1]);
			map = null;
		}
		br.close();
	}
		catch(IOException iue) {
			
		}
	}
	static class Range {
		int min;
		int max;
		public Range(int min,int max) {
			this.max = max;
			this.min = min;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Range) {
				Range temp = (Range)obj;
				if(temp.max == max && temp.min == min) 
					return true;
				
				return false;
			}
			return false;
		}
		public boolean inRange(Range r) {
			if((r.max >= min && r.max <= max) || (r.min <= max && r.min >= min))
				return true;
			
			return false;
		}
	}
}
