package study;

import java.io.*;
import java.util.*;

public class Main_boj_2210_숫자판점프 {
	static int n = 5, dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
	static char map[][], selected[];
	static Set<String> hSet;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<5;j++)
				map[i][j] = st.nextToken().charAt(0);
		}
		hSet = new HashSet<String>();
		selected = new char[6];
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				permutation(i, j, 0);
		System.out.println(hSet.size());
	}
	private static void permutation(int r, int c, int count) {
		if(count == 6) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<6;i++)
				sb.append(selected[i]);
			hSet.add(sb.toString());
			return;
		}
		
		for(int d=0;d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0||nc<0||nr>=n||nc>=n)
				continue;
			
			selected[count] = map[nr][nc];
			permutation(nr, nc, count+1);
		}
	}
}
