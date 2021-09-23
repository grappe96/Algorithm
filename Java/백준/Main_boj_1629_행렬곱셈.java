package study;

import java.util.Scanner;

public class Main_boj_1629_Çà·Ä°ö¼À {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		sc.close();
		
		System.out.println(multiplication(A, B, C));
	}

	private static long multiplication(long a, long b, long c) {
		if(b == 1)
			return a%c;
		
		long half = multiplication(a, b/2, c);
		
		if(b%2 == 1)
			return (half*half%c)*a%c;
			
		return half*half%c;
	}
}
