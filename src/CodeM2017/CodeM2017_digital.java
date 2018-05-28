package CodeM2017;

import java.util.Scanner;

public class CodeM2017_digital {
	public static void compute(long [] arr,long r){
        for(int i=1;i<=9;i++){
              
            for(long j=1;i*j<=r;j*=10){
                long start=i*j;
                long end=Math.min((i+1)*j-1,r);
                //�������λ��λ1����˵�� 1 10 11 12 �� 19 100 101 102 �� 199 ��. 
//                ����������������� 1-k �������Ļ��𰸾��� k/1 + k/10 + k/11 + �� k/199�� 
//                ȷʵ�����˼����������ǵ�ö�ٵ� 10000000 ��ʱ��Ͳ������ˣ��ٰ���������ö�ٴ�����̫���ˡ� 
//                ���ʱ���ĸ��úܴ󣬿�������������������зֿ飬���� k/10000000 �� k/10009999 ������ܶ�һ��������ȡ������ 
//                ���ǿ��Խ��𰸶���ͬ�ķ�Ϊһ�飬����ö�����ӵ�ʱ��Ϳ��Ի����ˣ���10000000ֱ�ӻ���10009999�� 
//                ����ֻ�ܶ������Ϊ1�Ĳſ��ԡ��� s-k �������Ļ� �Ͱ� 1-s �� 1-k �������������ɡ� 
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
