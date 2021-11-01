package study;

import java.util.Scanner;

public class Main_boj_1292_쉽게푸는문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		int[] sequence = new int[1001];
		int idx = 1, num = 1;
		while(idx <= 1000) {
			int next = idx + idx < 1000 ? idx + idx : 1000;
			for(int i=idx;i<=next;i++)
				sequence[i] = num;
			idx += num++;
		}
		
		int count = 0;
		for(int i=a;i<=b;i++)
			count += sequence[i];
		System.out.println(count);
	}
}
