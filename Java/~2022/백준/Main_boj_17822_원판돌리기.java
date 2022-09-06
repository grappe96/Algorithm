package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_17822_원판돌리기 {
	static int N, M, T, map[][];
	static boolean isNumLeft;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(!isNumLeft && map[i][j]>0)
					isNumLeft = true;
			}
		}
		
		for(int tc=1;tc<=T&&isNumLeft;tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if(!isNumLeft)
				break;
			turn(x, d, k);
			if(isNumLeft)
				map = remove();
		}
		int answer = 0;
		for(int i=1;i<=N;i++)
			for(int j=0;j<M;j++)
				answer += map[i][j];
		System.out.println(answer);
	}
	private static int[][] remove() {
		int result[][] = new int[N+1][M], count = 0;
		for(int i=1;i<=N;i++) {
			int beforeI = i-1;
			int afterI = i+1;
			for(int j=0;j<M;j++) {
				int now = map[i][j];
				if(now == 0)
					continue;
				int beforeJ = j == 0 ? M-1 : j-1;
				int afterJ = j == M-1 ? 0 : j+1;
				boolean check = false;
				if(!check && beforeI > 0 && now == map[beforeI][j])
					check = true;
				if(!check && afterI <= N && now == map[afterI][j])
					check = true;
				if(!check && now == map[i][beforeJ])
					check = true;
				if(!check && now == map[i][afterJ])
					check = true;
				if(check) {
					count++;
					result[i][j] = 0;
				}else
					result[i][j] = now;
			}
		}
		if(count == 0) {
			plusMinus();
			return map;
		}
		return result;
	}
	private static void plusMinus() {
		float avg = 0, count = 0;
		for(int i=1;i<=N;i++)
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0)
					continue;
				avg += map[i][j];
				count++;
			}
		if(count == 0) {
			isNumLeft = false;
			return;
		}
		avg /= count;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0)
					continue;
				if(map[i][j] > avg)
					map[i][j] -= 1;
				else if(map[i][j] < avg)
					map[i][j] += 1;
			}
		}
	}
	private static void turn(int x, int d, int k) {
		if(d == 0) {
			while(--k>=0) {
				for(int i=x;i<=N;i+=x) {
					int tmp = map[i][M-1];
					for(int j=M-1;j>0;j--)
						map[i][j] = map[i][j-1];
					map[i][0] = tmp;
				}
			}
		} else {
			while(--k>=0) {
				for(int i=x;i<=N;i+=x) {
					int tmp = map[i][0];
					for(int j=0;j<M-1;j++) 
						map[i][j] = map[i][j+1];
					map[i][M-1] = tmp;
				}
			}
		}
	}
}
