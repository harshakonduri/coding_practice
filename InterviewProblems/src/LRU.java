import java.util.LinkedHashMap;


public class LRU< K , V> extends LinkedHashMap<K, V> {
	int cap;
	public LRU(int c) {
		super(c+1, 1.0f, true);
		cap = c;
	}
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		// TODO Auto-generated method stub
		return (cap < size());
	}
}
