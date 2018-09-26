package sort;

//这样写的意思是Key是一个泛型，并且这个泛型已经实现了Comparable接口
public class priorityQueues<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N=0;
	
	public priorityQueues(int maxN) {
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	public void swim(int k) {
		while(k>1 && less(k/2, k)) {
			exch(k/2, k);
			k /= 2;
		}
	}
	
	public void sink(int k) {
		while(2*k <= N) {
			int j=2*k;
			if(j<N && less(j, j+1))	j++;
			if(!less(k, j))		break;
			exch(k, j);
			k = j;
		}
	}
	
	public void sink(Comparable[] pq, int k, int n) {
		while(2*k <= n) {
			int j = 2*k;
			if(j < n && less(pq, j, j+1))		j ++;
			if(!less(pq, k, j))		break;
			exch(pq, k, j);
			k = j;
		}
	}
	
	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i-1].compareTo(pq[j-1]) < 0;
	}
	
	private void exch(Object[] pq, int i, int j) {
		Object swap = pq[i-1];
		pq[i-1] = pq[j-1];
		pq[j-1] = swap;
	}
	
	private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
	
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    
    
    public void sort(Comparable[] a) {
    	int N = a.length;
		for(int k=N/2; k>=1; k--) {
			sink(a, k, N);
		}
		
		while(N>1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
    
    
    public static void main(String[] args) {
    	priorityQueues<String> pq = new priorityQueues<String>(50);
//    	pq.insert("q");
//    	pq.insert("a");
//    	pq.insert("z");
//    	pq.insert("r");
//    	pq.insert("w");
//    	pq.insert("b");
//    	pq.insert("n");
//    	pq.insert("d");
//    	pq.insert("l");
//    	pq.insert("m");
//    	pq.insert("i");
//    	pq.insert("s");
//    	Comparable[] array = {10, 84,22, 2, 71,45,76,93,23,56,67,34,23,74,2,1,54,28,4,37,25,14};
    	Comparable[] array = {10, 84,22, 2, 71,45,76,93,23,56,67};
    	pq.sort(array);
    	
    	for(Comparable<Integer> a: array) {
    		System.out.print(" "+a);
    	}
    	
    }
}
