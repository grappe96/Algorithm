package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_21611_마법사상어와블리자드 {
	static int N, M, block[], spell[][], one, two, three;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] tmp = new int[N+1][N+1];
		block = new int[N*N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<=N;j++)
				tmp[i][j] = Integer.parseInt(st.nextToken());
		}
		spell = new int[M][2];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			spell[i][0] = Integer.parseInt(st.nextToken());
			spell[i][1] = Integer.parseInt(st.nextToken());
		}
		int x = (N+1)/2, y = x;
		block[1] = tmp[y][x];
		int idx = 2, dr[] = {0,1,0,-1}, dc[] = {-1,0,1,0}, move = 1, d = 0;
		while(move < N) {
			int time = move == N-1 ? 3 : 2;
			for(int i=0;i<time;i++) {
				for(int j=0;j<move;j++) {
					y+=dr[d];
					x+=dc[d];
					block[idx++] = tmp[y][x];
				}
				d = (d+1)%4;
			}
			move++;
		}
		tmp = null;
		idx = 0;
		while(--M>=0) {
			doMagic(spell[idx][0], spell[idx++][1]);
			fillBlank();
			while(explode()>0)
				fillBlank();
			block = change();
		}
		System.out.println(one+two*2+three*3);
	}
	private static void doMagic(int d, int s) {
		int idx = 1, num = 0;
		switch(d) {
			case 1:
				idx += 7;
				num = 4;
				break;
			case 2:
				idx += 3;
				num = 2;
				break;
			case 3:
				idx += 1;
				num = 1;
				break;
			case 4:
				idx += 5;
				num = 3;
				break;
		}
		while(--s>=0) {
			block[idx] = 0;
			num += 4;
			idx += num*2-1;
		}
	}
	private static void fillBlank() {
		int size = N*N;
		for(int i=2;i<size;i++) {
			if(block[i] > 0)
				continue;
			int j=i+1;
			while(j<=size && block[j] == 0)
				j+=1;
			if(j<=size) {
				block[i] = block[j];
				block[j] = 0;
			}
		}
	}
	private static int explode() {
		int count = 1, num = block[2], start = 2, size = N*N, result = 0;
		for(int i=3;i<=size;i++) {
			int now = block[i];
			if(now == num)
				count++;
			else {
				if(count >= 4) {
					switch(num) {
					case 1:
						one+=count;
						break;
					case 2:
						two+=count;
						break;
					case 3:
						three+=count;
						break;
					}
					for(int j=start;j<i;j++)
						block[j] = 0;
					result++;
				}
				if(now == 0)
					break;
				start = i;
				num = now;
				count = 1;
			}
		}
		return result;
	}
	private static int[] change() {
		int idx = 2, size = N*N, num = block[2], count = 1;
		int[] result = new int[size+1];
		for(int i=3;i<=size;i++) {
			int now = block[i];
			if(now == num) 
				count++;
			else {
				result[idx] = count;
				if(idx+1 <= size)
					result[idx+1] = num;
				else
					break;
				if(idx+2 <= size)
					idx += 2;
				else
					break;
				if(now == 0)
					break;
				num = now;
				count = 1;
			}
		}
		
		return result;
	}
}
