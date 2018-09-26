package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class quickSort {
	public static void sort(Comparable[] a) {
//		List<Comparable> aList = Arrays.asList(a);
//		Collections.shuffle(aList);
//		a = aList.toArray(new Comparable[aList.size()]);
		sort(a, 0, a.length-1);
	}
	
	public static void sort(Comparable[] a, int lo, int hi) {
		if(hi<=lo)	return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		//Ëæ»ú»®·Ö
		Random rand = new Random();
		int temp = rand.nextInt(hi-lo+1)+lo;
		exch(a, lo, temp);
		Comparable v = a[lo];
		while(true) {
			while(less(a[++i], v))		if(i==hi)	break;
			while(less(v, a[--j]))		if(j==lo)	break;
			if(i>=j)		break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	private static void sort3way(Comparable[] a) {
		sort3way(a, 0, a.length-1);
	}
	
	private static void sort3way(Comparable[] a, int lo, int hi) {
		if(hi<=lo)	return;
		int lt = lo, i=lo+1, gt=hi;
		Comparable v = a[lo];
		while(i<=gt) {
			int cmp = a[i].compareTo(v);
			if(cmp<0)		exch(a, i++, lt++);
			else if(cmp>0)		exch(a, i, gt--);
			else i++;
		}
		sort3way(a, lo, lt-1);
		sort3way(a, gt+1, hi);
	}
	
	
	private static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	
	public static void main(String[] args) {
    	Comparable[] array = {10, 84,22, 2, 71,45,76,93,35,56,67,34,23,74,2,1,54,28,4,37,25,14,15};
    	quickSort.sort3way(array);
    	
    	for(Comparable<Integer> a: array) {
    		System.out.print(" "+a);
    	}
    	
    }
}
