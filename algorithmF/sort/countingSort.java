package sort;

public class countingSort {
	public static int[] countSort(int[] a) {
		int[] b = new int[a.length];
		int[] c = new int[10];
		
		for(int i=0; i<a.length; i++) {
			c[a[i]] += 1;
		}
		for(int i=1; i<c.length; i++) {
			c[i] += c[i-1];
		}
		for(int i=a.length-1; i>=0; i--) {
			b[c[a[i]]-1] = a[i];
			c[a[i]] -=1;
		}
		return b;
	}
	
	public static void main(String[] args) {
    	int[] array = {1,5,2,4,6,0,4,8,6,3,4,7,2,0,9};
    	int[] b = countSort(array);
    	
    	for(int a: b) {
    		System.out.print(" "+a);
    	}
    	
    }
}
