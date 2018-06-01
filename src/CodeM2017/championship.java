package CodeM2017;

import java.util.Scanner;

public class championship {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int peopleNum = scanner.nextInt();
		int[] score = new int[peopleNum];
        for (int i = 0; i < score.length; i++) {
            score[i] = scanner.nextInt();
        }
		System.out.println(success(peopleNum, score));
	}
	
	public static int success(int peopleNum, int[] score) {
		int lowNum = 1, highNum = 0;
		int cur = score[0];
		for(int i=1; i<peopleNum; i++) {
			if(score[i] > cur)	highNum++;
			else		lowNum++;
		}
		if(highNum == 0) {
			return round(lowNum);
		}
		return lowNum>highNum ? round(peopleNum/2): round(lowNum);
	}
	
	public static int round(int num) {
		return (int) (Math.log(num) / Math.log(2));
	}
}
