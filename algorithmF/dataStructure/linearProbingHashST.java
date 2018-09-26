package dataStructure;

public class linearProbingHashST<Key, Value> {
	private static final int INIT_CAPACITY = 16;
	private int n=0;
	private int m=16;
	private Key[] keys;
	private Value[] values;
	
	public	linearProbingHashST() {
		this(INIT_CAPACITY);
	}
	
	public linearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        values = (Value[]) new Object[m];
    }
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff)%m;
	}
	
	public void put(Key key, Value val) {
		if(n>=m/2)
			resize(2*n);
		int i ;
		for(i = hash(key); keys[i]!=null; i=(i+1)%m) {
			if(keys[i].equals(key)) {
				values[i] = val;
			}
		}
		keys[i] = key;
		values[i] = val;
		n++;
	}
	
	public Value get(Key key) {
		for(int i=hash(key); keys[i] != null; i=(i+1)%m) {
			if(keys[i].equals(key)) {
				return values[i];
			}
		}
		return null;
	}
	
	public void delete(Key key) {
		int i = hash(key);
		while(!key.equals(keys[i])) {
			i = (i+1)%m;
		}
		keys[i] = null;
		values[i] = null;
		i = (i+1)%m;
		while(keys[i] != null) {
			Key keyToReDo = keys[i];
			Value valToReDo = values[i];
			keys[i] = null;
			values[i] = null;
			n--;
			put(keyToReDo, valToReDo);
			i = (i+1)%m;
		}
		n--;
		if(n>0 && n==m/8) {
			resize(m/2);
		}
	}
	
	public void resize(int cap) {
		linearProbingHashST<Key, Value> temp = new linearProbingHashST<Key, Value>(cap);
		for(int i=0; i<m; i++) {
			if(keys[i] != null) {
				temp.put(keys[i], values[i]);
			}
		}
		keys = temp.keys;
		values = temp.values;
		m = temp.m;
	}
	
	
	
}
