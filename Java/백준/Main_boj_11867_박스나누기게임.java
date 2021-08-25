package week4;

import java.util.Scanner;

public class Main_boj_11867_박스나누기게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		
		if(N%2 == 0 || M%2 == 0)
			System.out.println('A');
		else
			System.out.println('B');
	}
}
