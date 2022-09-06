package study;

import java.io.*;

public class Main_boj_1063_ŷ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int[] king = new int[2];
		king[0] = tmp[0].charAt(1) - '0';
		king[1] = tmp[0].charAt(0) - 65;
		int[] stone = new int[2];
		stone[0] = tmp[1].charAt(1) - '0';
		stone[1] = tmp[1].charAt(0) - 65;
		int N = Integer.parseInt(tmp[2]);
		
		int[] dr = {0,0,-1,1,1,1,-1,-1}, dc = {1,-1,0,0,1,-1,1,-1};
		for(int n=0;n<N;n++) {
			String s = br.readLine();
			int nr = king[0], nc = king[1], d = -1;
			switch(s) {
				case "R":
					d = 0;
					break;
				case "L":
					d = 1;
					break;
				case "B":
					d = 2;
					break;
				case "T":
					d = 3;
					break;
				case "RT":
					d = 4;
					break;
				case "LT":
					d = 5;
					break;
				case "RB":
					d = 6;
					break;
				case "LB":
					d = 7;
					break;
			}
			
			nr += dr[d];
			nc += dc[d];
			if(nr<=0||nc<0||nr>8||nc>=8)
				continue;
			if(nr == stone[0] && nc == stone[1]) {
				int nsR = stone[0] + dr[d];
				int nsC = stone[1] + dc[d];
				
				if(nsR<=0||nsC<0||nsR>8||nsC>=8)
					continue;
				
				stone[0] = nsR;
				stone[1] = nsC;
			}
			king[0] = nr;
			king[1] = nc;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append((char) (king[1]+65)).append(king[0]);
		System.out.println(sb.toString());
		sb = new StringBuilder();
		sb.append((char) (stone[1]+65)).append(stone[0]);
		System.out.println(sb.toString());
	}
}
