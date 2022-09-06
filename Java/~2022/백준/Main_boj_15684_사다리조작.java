package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_15684_사다리조작 {
	static int min, N, H, ladder[][];
	static boolean possible;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ladder = new int[H+1][N+1];
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b+1] = ++ladder[a][b] + 1;
		}
		
		min = 0;
		if(!isPossible()) {
			for(int i=1;i<=3;i++) {
				min = i;
				dfs(0);
				if(possible)
					break;
			}
			if(!possible)
				min = -1;
		}
		System.out.print(min);
	}
	private static void dfs(int count) {
		if(count == min) {
			if(isPossible())
				possible = true;
			return;
		}
		
		if(possible)
			return;
		
		for(int i=1;i<=N-1;i++) {
			for(int j=1;j<=H;j++) {
				if(ladder[j][i] == 0 && ladder[j][i+1] == 0) {
					ladder[j][i+1] = ++ladder[j][i]+1;
					dfs(count + 1);
					ladder[j][i] = ladder[j][i+1] = 0;
				}
			}
		}
	}
	private static boolean isPossible() {
		for(int i=1;i<=N;i++) {
			int r = i;
			
			for(int j=1;j<=H;j++) {
				if(ladder[j][r] == 0)
					continue;
				
				if(ladder[j][r] == 1)
					r++;
				else
					r--;
			}
			if(r != i)
				return false;
		}
		return true;
	}
}
