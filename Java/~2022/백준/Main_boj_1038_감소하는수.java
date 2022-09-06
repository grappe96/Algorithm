package study;

import java.util.Scanner;

public class Main_boj_1038_감소하는수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		String[] arr = new String[1000001];
		for(int i=0;i<10;i++)
			arr[i] = Integer.toString(i);
		int start = 1, startNow = 0, endNow = 9, startNext = 0, idx = 10;
		boolean isEnd = false;
		while(idx<=N) {
			startNext = idx;
			for(int first = start;!isEnd&&first<=9;first++) {
				for(int i=startNow;i<=endNow;i++) {
					if(first <= arr[i].charAt(0)-'0')
						break;
					StringBuilder sb = new StringBuilder();
					sb.append(first).append(arr[i]);
					arr[idx] = sb.toString();
					if(arr[idx++].length() == 10) {
						if(idx-1 != N)
							arr[N] = "-1";
						isEnd = true;
						break;
					}
				}
			}
			if(isEnd)
				break;
			startNow = startNext;
			endNow = idx-1;
			start++;
		}
		System.out.print(arr[N]);
	}
}
