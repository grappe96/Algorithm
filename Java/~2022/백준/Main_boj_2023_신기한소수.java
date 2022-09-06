package study;

import java.util.*;

public class Main_boj_2023_신기한소수 {
	static int N;
	static String[] first = {"2","3","5","7"}, num = {"1","3","7","9"};
	static List<String> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		
		StringBuilder sb = new StringBuilder();
		if(N==1) {
			for(int i=0;i<4;i++)
				sb.append(first[i]).append("\n");
		} else {
			list = new ArrayList<String>();
			for(int i=0;i<4;i++)
				makePrime(first[i], 1);
			
			Collections.sort(list);
			int size = list.size();
			for(int i=0;i<size;i++)
				sb.append(list.get(i)).append("\n");
		}
		System.out.print(sb.toString());
	}
	private static boolean checkPrime(int n) {
		for(int i=2;i*i<n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	private static void makePrime(String s, int count) {
		if(count == N) {
			if(checkPrime(Integer.parseInt(s)))
				list.add(s);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		for(int i=0;i<4;i++) {
			sb.append(num[i]);
			if(checkPrime(Integer.parseInt(sb.toString())))
				makePrime(sb.toString(), count+1);
			sb.deleteCharAt(count);
		}
	}
}
