package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_17825_¡÷ªÁ¿ß¿∑≥Ó¿Ã {
	static class Square {
		int num, idx;
		boolean isRed;
		Square left, right;
		public Square(int num, int idx, boolean isRed, Square left, Square right) {
			this.num = num;
			this.idx = idx;
			this.isRed = isRed;
			this.left = left;
			this.right = right;
		}
	}
	static class Horse {
		int idx;
		boolean isOut;
		public Horse(int idx, boolean isOut) {
			this.idx = idx;
			this.isOut = isOut;
		}
	}
	static int dice[] = new int[10], score, save[] = new int[10];
	static Square[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<10;i++)
			dice[i] = Integer.parseInt(st.nextToken());
		
		map = new Square[31];
		map[19]= new Square(40, 19, true, null, null);
		for(int i=18;i>=0;i--)
			map[i] = new Square((i+1)*2, i, true, map[i+1], null);

		map[30] = new Square(35, 30, true, map[19], null);
		map[29] = new Square(30, 29, true, map[30], null);
		map[28] = new Square(25, 28, true, map[29], null);
		
		map[22] = new Square(19, 22, true, map[28], null);
		map[21] = new Square(16, 21, true, map[22], null);
		map[20] = new Square(13, 20, true, map[21], null);
		Square tmp = map[4];
		map[4] = new Square(tmp.num, tmp.idx, false, tmp.left, map[20]);
		
		map[24] = new Square(24, 24, true, map[28], null);
		map[23] = new Square(22, 23, true, map[24], null);
		tmp = map[9];
		map[9] = new Square(tmp.num, tmp.idx, false, tmp.left, map[23]);
		
		map[27] = new Square(26, 27, true, map[28], null);
		map[26] = new Square(27, 26, true, map[27], null);
		map[25] = new Square(28, 25, true, map[26], null);
		tmp = map[14];
		map[14] = new Square(tmp.num, 14, false, tmp.left, map[25]);
		
		permutation(0, 0);
		System.out.println(score);
	}
	private static void permutation(int horseNum, int diceNum) {
		if(diceNum == 10) {
			Horse[] horse = new Horse[4];
			for(int i=0;i<4;i++)
				horse[i] = new Horse(-1, false);
			
			horse[save[0]].idx = dice[0]-1;
			Square tmp = map[horse[save[0]].idx];
			int sum = tmp.num;
			for(int i=1;i<10;i++) {
				Horse h = horse[save[i]];
				if(h.isOut)
					continue;
				int d = dice[i];
				if(h.idx == -1)
					tmp = map[0];
				else if(!map[h.idx].isRed)
					tmp = map[h.idx].right;
				else
					tmp = map[h.idx].left;
				--d;
				if(tmp == null) {
					h.isOut = true;
					continue;
				}
				h.idx = tmp.idx;
				while(--d>=0) {
					tmp = tmp.left;
					if(tmp == null) {
						h.isOut = true;
						break;
					}
					h.idx = tmp.idx;
				}
				if(h.isOut)
					continue;
				for(int j=0;j<4;j++) {
					if(j==save[i])
						continue;
					if(!horse[j].isOut && h.idx == horse[j].idx)
						return;
				}
				sum += tmp.num;
			}
			score = Math.max(score, sum);
			return;
		}
		for(int i=0;i<4;i++) {
			save[diceNum] = i;
			permutation(i, diceNum+1);
		}
	}
}
