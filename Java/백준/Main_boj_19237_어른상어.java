package study;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main_boj_19237_어른상어 {
	static class Smell {
		int num, time;
		public Smell(int num) {
			this.num = num;
			this.time = K;
		}
	}
	static class Shark implements Comparable<Shark>{
		int num, r, c;
		public Shark(int num, int r, int c) {
			this.num = num;
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Shark o) {
			return this.num - o.num;
		}
	}
	static int N, M, K, dr[] = {0,-1,1,0,0}, dc[] = {0,0,0,-1,1};
	static HashMap<Integer, Integer> direction = new HashMap<Integer, Integer>();
	static HashMap<Integer, int[][]> priorities = new HashMap<Integer, int[][]>();
	static HashMap<Integer, LinkedList<Shark>> squares = new HashMap<Integer, LinkedList<Shark>>();
	static Smell[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Smell[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				int sharkNum = Integer.parseInt(st.nextToken());
				map[i][j] = new Smell(sharkNum);
				if(sharkNum == 0)
					continue;
				int num = i*N+j;
				LinkedList<Shark> list = new LinkedList<Shark>();
				list.add(new Shark(sharkNum, i, j));
				squares.put(num, list);
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=M;i++)
			direction.put(i, Integer.parseInt(st.nextToken()));
		for(int i=1;i<=M;i++) {
			int[][] priority = new int[5][4];
			for(int j=1;j<5;j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k=0;k<4;k++)
					priority[j][k] = Integer.parseInt(st.nextToken());
			}
			priorities.put(i, priority);
		}
		int second = 0;
		while(++second<=1000) {
			squares = move();
			smellLighter();
			squares = displace();
			if(direction.size() == 1)
				break;
		}
		if(second>1000)
			second = -1;
		System.out.println(second);
	}
	private static HashMap<Integer, LinkedList<Shark>> displace() {
		HashMap<Integer, LinkedList<Shark>> result = new HashMap<Integer, LinkedList<Shark>>();
		Iterator<Entry<Integer, LinkedList<Shark>>> iter = squares.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, LinkedList<Shark>> square = iter.next();
			LinkedList<Shark> list = square.getValue();
			int size = list.size();
			if(size > 1) {
				LinkedList<Shark> newList = new LinkedList<Shark>();
				Collections.sort(list);
				Shark shark = list.get(0);
				newList.add(shark);
				map[shark.r][shark.c] = new Smell(shark.num);
				int newNum = shark.r*N+shark.c;
				result.put(newNum, newList);
				for(int i=1;i<size;i++) {
					shark = list.get(i);
					direction.remove(shark.num);
					priorities.remove(shark.num);
				}
			} else {
				Shark shark = list.get(0);
				map[shark.r][shark.c] = new Smell(shark.num);
				int newNum = shark.r*N+shark.c;
				result.put(newNum, list);
			}
		}
		return result;
	}
	private static void smellLighter() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j].num == 0)
					continue;
				map[i][j].time -= 1;
				if(map[i][j].time == 0)
					map[i][j] = new Smell(0);
			}
		}
	}
	private static HashMap<Integer, LinkedList<Shark>> move() {
		HashMap<Integer, LinkedList<Shark>> result = new HashMap<Integer, LinkedList<Shark>>();
		Iterator<Entry<Integer, LinkedList<Shark>>> iter = squares.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, LinkedList<Shark>> square = iter.next();
			int num = square.getKey();
			int r = num/N;
			int c = num%N;
			Shark shark = square.getValue().get(0);
			int[] priority = priorities.get(shark.num)[direction.get(shark.num)];
			boolean check = false;
			int tmp[] = new int[2];
			for(int d : priority) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(nr<0||nc<0||nr>=N||nc>=N||map[nr][nc].num > 0)
					continue;
				check = true;
				int newNum = nr*N+nc;
				tmp[0] = nr;
				tmp[1] = nc;
				direction.put(shark.num, d);
				if(!result.containsKey(newNum))
					result.put(newNum, new LinkedList<Shark>());
				result.get(newNum).add(new Shark(shark.num, nr, nc));
				break;
			}
			if(!check) {
				for(int d : priority) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(nr<0||nc<0||nr>=N||nc>=N||map[nr][nc].num!=shark.num)
						continue;
					int newNum = nr*N+nc;
					tmp[0] = nr;
					tmp[1] = nc;
					direction.put(shark.num, d);
					if(!result.containsKey(newNum))
						result.put(newNum, new LinkedList<Shark>());
					result.get(newNum).add(new Shark(shark.num, nr, nc));
					break;
				}
			}
		}
		return result;
	}
}
