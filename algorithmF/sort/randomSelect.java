package sort;

import java.util.Random;

public class randomSelect {
	
	public static int randomSelect(int[] a,  int i) {
		return randomSelect(a, 0, a.length-1, i);
	}
	
	public static int randomSelect(int[] a, int lo, int hi, int i) {
		if(lo == hi) {
			return a[lo];
		}
		int part = partition(a, lo, hi);
		int lowPartNum = part - lo +1;
		
		if(lowPartNum == i) {
			return a[part];
		}else if(lowPartNum < i) {
			return randomSelect(a, part+1, hi, i-lowPartNum);
		}else {
			return randomSelect(a, lo, part-1, i);
		}
	}
	
	private static int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		//随机划分
		Random rand = new Random();
		int temp = rand.nextInt(hi-lo+1)+lo;
		exch(a, lo, temp);
		int v = a[lo];
		while(true) {
			while(less(a[++i], v))		if(i==hi)	break;
			while(less(v, a[--j]))		if(j==lo)	break;
			if(i>=j)		break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	
	public static int select(int[] a, int i) {
		return select(a, 0, a.length-1, i);
	}
	
	public static int select(int[] a, int lo, int hi, int i) {
		
		if(lo == hi)
			return a[lo];
		//中位数的中位数数组， m:中位数个数
		int[] MM = new int[(hi-lo+1)/5 + 1];
		int m = 0;
		
		for(int j=lo; j<=hi; j+=5) {
			int temp = insertSort(a, j, Math.min(hi+1, j+5));
			MM[m++] = temp;
		}
		
		int mmNum = select(MM, 0, m-1, (m-1)/2);
		int part = partitionM(a, lo, hi, mmNum);
		int lowPartNum = part-lo+1;
		
		if(lowPartNum==i) {
			return a[part];
		}else if(lowPartNum<i) {
			return select(a, part+1, hi, i-lowPartNum);
		}else {
			return	select(a, lo, part, i);
		}
	}
	
	private static int partitionM(int[] a, int lo, int hi, int num) {
		int i = lo, j = hi+1;

		for(int k=lo; k<hi; k++) {
			if(a[k] == num) {
				exch(a, k, lo);
				break;
			}
		}
		int v = a[lo];
		while(true) {
			while(less(a[++i], v))		if(i==hi)	break;
			while(less(v, a[--j]))		if(j==lo)	break;
			if(i>=j)		break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	

	private static int insertSort(int[] a, int lo, int hi) {
		for(int i=lo+1; i<hi; i++) {
			for(int j=i; j>lo && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
		if(!order(a, lo, hi)) {
			System.out.println("fuck");
		}
		return a[(lo+hi)/2];
	}
	
	private static boolean order(int[] a , int i, int j) {
        for(int k=i+1; k<j; k++) {
        	if(a[k]<a[k-1]) {
        		return false;
        	}
        }
        return true;
    }
	
	
	private static boolean less(int i, int j) {
        return i<j;
    }
	
	private static void exch(int[] a, int i, int j) {
		int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	
	public static void main(String[] args) {
    	int[] array = {10, 84,22, 8, 71,45,76,93,35,56,67,34,23,74,7,4,54,28,4,37,25,14,15};
    	int a = randomSelect(array, 1);
    	System.out.println(a);
    	
//    	for(int a: array) {
//    		System.out.print(" "+a);
//    	}
    }
}
