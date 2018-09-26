package sort;


public class Merge {
	
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i=lo, j=mid+1;
		assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);
		
		for(int k = lo; k<=hi; k++) {
			aux[k] = a[k];
		}
		
		for(int k=lo; k<=hi; k++) {
			if(i>mid)	a[k] = aux[j++];
			else if(j>hi)		a[k] = aux[i++];
			else if(less(aux[i], aux[j]))	a[k] = aux[i++];
			else a[k] = aux[j++];
		}
    }
	
	//自顶向下
	private static Comparable[] aux;
	public static void sortDown(Comparable[] a) {
		aux = new Comparable[a.length];
		sortDown(a, 0, a.length-1);
		assert isSorted(a);
	}
        
	public static void sortDown(Comparable[] a, int lo, int hi) {
		if(hi <= lo) {
			return;
		}
		int mid = (lo+hi)/2;
		sortDown(a, lo, mid);
		sortDown(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	
	//自底向上
	public static void sortUp(Comparable[] a) {
		int len = a.length;
		aux = new Comparable[len];
		for(int sz=1; sz<len; sz=sz+sz) {
			for(int lo=0; lo<len-sz; lo+=sz+sz) {
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, len-1));
			}
		}
	}
	
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
	
	
		public static void main(String [] args){
			Comparable[] chars2 = {1,69,5,33,88,14,5,2,99,4,9,8,7,12};
			sortUp(chars2);
		    
		    for(Comparable num : chars2) {
		    	System.out.print(" "+num);
		    }
//		    int res = sortDown(chars2);
//	        System.out.println(res);
	        
	}
}
