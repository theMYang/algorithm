package CodeM2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class music {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] na = new int[n];
        for (int i = 0; i < n; i++) {
            na[i] = Integer.parseInt(str[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int[] ma = new int[m];
        str = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            ma[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solution(n, na, m, ma));
        br.close();
    }
 
    public static long solution(int n, int[] na, int m, int[] ma) {
        long min = Long.MAX_VALUE;
        for (int i = 0; i + n <= m; i++) {
            long diff = diff(n, na, i, ma);
            if (diff < min)
                min = diff;
        }
        return min;
    }
 
    public static long diff(int n, int[] na, int index, int[] ma) {
        long diff = 0;
        for (int i = 0; i < n; i++) {
            diff += (na[i] - ma[index + i]) * (na[i] - ma[index + i]);
        }
        return diff;
    }
}
