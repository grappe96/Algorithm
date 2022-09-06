package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_17837_새로운게임2 {
	static class Horse{
		int r, c, d;
		public Horse(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	static int N, map[][][], dr[] = {0,-1,0,1}, dc[] = {1,0,-1,0};
	static Horse horse[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][N][6];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++)
				map[i][j][0] = Integer.parseInt(st.nextToken());
		}
		horse = new Horse[K+1];
		for(int i=1;i<=K;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			if(d == 1)
				d = 2;
			else if(d == 2)
				d = 1;
			horse[i] = new Horse(r, c, d);
			map[r][c][1] = i;
			map[r][c][5] = 1;
		}
		int count = 0;
		boolean isOverFour = false;
		
		while(!isOverFour && ++count <= 1000) {
			for(int i=1;i<=K;i++) {
				Horse h = horse[i];
				int[] now = map[h.r][h.c];
				int startIdx = 1, endIdx = now[5];
				if(now[1] != i) {
					for(int j=2;j<=endIdx;j++)
						if(now[j] == i) {
							startIdx = j;
							break;
						}
				}
				int nr = h.r + dr[h.d];
				int nc = h.c + dc[h.d];
				
				if(checkBlue(nr, nc)) {
					h.d = (h.d+2)%4;
					horse[i].d = h.d;
					nr = h.r + dr[h.d];
					nc = h.c + dc[h.d];
					
					if(checkBlue(nr, nc))
						continue;
				}
				if(map[nr][nc][0] == 1)
					isOverFour = moveToRed(now, nr, nc, startIdx, endIdx);
				else
					isOverFour = moveToWhite(now, nr, nc, startIdx, endIdx);
				
				if(isOverFour)
					break;

				int r = h.r, c = h.c;
				map[r][c][5] = startIdx-1;
				for(int j=startIdx;j<=endIdx;j++) {
					int hNum = map[r][c][j];
					if(hNum == 0)
						continue;
					map[r][c][j] = 0;
					horse[hNum].r = nr;
					horse[hNum].c = nc;
				}
			}
		}
		if(count > 1000)
			count = -1;
		System.out.println(count);
	}
	private static boolean moveToWhite(int[] now, int nr, int nc, int start, int end) {
		int endIdx = map[nr][nc][5], size = end-start+1 + endIdx;
		if(size >= 4)
			return true;
		
		map[nr][nc][5] = size;
		for(int i=endIdx+1;i<=size;i++)
			map[nr][nc][i] = now[start++];
		return false;
	}
	private static boolean moveToRed(int[] now, int nr, int nc, int start, int end) {
		int endIdx = map[nr][nc][5], size = end-start+1 + endIdx;
		if(size >= 4)
			return true;
		
		int[] result = new int[6];
		for(int i=start;i<=end;i++)
			result[i] = now[end-(i-start)];
		map[nr][nc][5] = size;
		for(int i=endIdx+1;i<=size;i++)
			map[nr][nc][i] = result[start++];
		return false;
	}
	private static boolean checkBlue(int r, int c) {
		if(r<0||c<0||r>=N||c>=N||map[r][c][0]==2)
			return true;
		else
			return false;
	}
}
