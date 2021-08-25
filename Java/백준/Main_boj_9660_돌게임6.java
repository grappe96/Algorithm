package week8;

import java.util.Scanner;

public class Main_boj_9660_µπ∞‘¿”6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		boolean[] check = {false, true, false, true, true, true, true};
		
		int idx = (int) (n%7);
		
		if(check[idx])
			System.out.println("SK");
		else
			System.out.println("CY");
		sc.close();
	}
}
