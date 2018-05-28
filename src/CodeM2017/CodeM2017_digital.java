package CodeM2017;

import java.util.Scanner;

public class CodeM2017_digital {
	public static void compute(long [] arr,long r){
        for(int i=1;i<=9;i++){
              
            for(long j=1;i*j<=r;j*=10){
                long start=i*j;
                long end=Math.min((i+1)*j-1,r);
                //对于最高位数位1的来说有 1 10 11 12 … 19 100 101 102 … 199 …. 
//                假设我们求得区间是 1-k 。这样的话答案就是 k/1 + k/10 + k/11 + … k/199。 
//                确实减少了计算量，倒是但枚举到 10000000 的时候就不合适了，再按上述方法枚举次数就太多了。 
//                这个时候分母变得很大，可以利用这个特性来进行分块，例如 k/10000000 与 k/10009999 结果可能都一样（向下取整）。 
//                我们可以将答案都相同的分为一块，这样枚举因子的时候就可以滑动了，从10000000直接滑倒10009999。 
//                但是只能对于起点为1的才可以。求 s-k 这个区间的话 就把 1-s 与 1-k 都求出来相减即可。 
                //start,end(1==2):2,2; 20,29; 200,299...
                  
                long spli=1;
                for(long k=start;k<=end;k+=spli){
                    long mul=r/k;
                    long rema=r-mul*k;
                    spli=1;
                    spli+=Math.min(rema/mul,end-k);
                    arr[i]+=mul*spli;
                }
            }
        }
    }
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        long a=in.nextLong();
        long b=in.nextLong();
        long []arrA=new long[10];
        long []arrB=new long[10];
        compute(arrA,a-1);
        compute(arrB,b);
        for(int i=1;i<10;i++){
            System.out.println(arrB[i]-arrA[i]);
        }
    }
}
