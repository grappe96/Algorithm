package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_1806_ºÎºÐÇÕ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] num = new int[N];
		for(int i=0;i<N;i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		int min = 100001, start = 0, end = 0, sum = num[0];
		while(start < N) {
			if(sum >= S) {
				min = Math.min(min, end-start+1);
				sum -= num[start++];
			} else if(end<N-1)
				sum += num[++end];
			else
				break;
		}
		if(min == 100001)
			min = 0;
		System.out.println(min);
	}
}
