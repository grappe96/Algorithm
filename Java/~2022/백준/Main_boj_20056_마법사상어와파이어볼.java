package study;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main_boj_20056_마법사상어와파이어볼 {
	static class FireBall {
		int m, s, d;
		public FireBall(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	static int N, M, dr[] = {-1,-1,0,1,1,1,0,-1}, dc[] = {0,1,1,1,0,-1,-1,-1};
	static HashMap<Integer, ArrayList<FireBall>> hMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		hMap = new HashMap<Integer, ArrayList<FireBall>>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int num = (r-1)*N+c;
			if(!hMap.containsKey(num))
				hMap.put(num, new ArrayList<FireBall>());
			hMap.get(num).add(new FireBall(m, s, d));
		}
		while(--K>=0) {
			hMap = move();
			hMap = mergeNDivide();
		}
		Iterator<Entry<Integer, ArrayList<FireBall>>> iter = hMap.entrySet().iterator();
		int answer = 0;
		while(iter.hasNext()) {
			Entry<Integer, ArrayList<FireBall>> next = iter.next();
			ArrayList<FireBall> balls = next.getValue();
			int size = balls.size();
			for(int i=0;i<size;i++) {
				FireBall now = balls.get(i);
				answer += now.m;
			}
		}
		System.out.println(answer);
	}
	private static HashMap<Integer, ArrayList<FireBall>> mergeNDivide() {
		HashMap<Integer, ArrayList<FireBall>> result = new HashMap<Integer, ArrayList<FireBall>>();
		Iterator<Entry<Integer, ArrayList<FireBall>>> iter = hMap.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, ArrayList<FireBall>> next = iter.next();
			ArrayList<FireBall> list = next.getValue();
			int num = list.size();
			if(num > 1) {
				FireBall now = list.get(0);
				int weight = now.m, speed = now.s, isOdd = now.d%2;
				boolean isAllSame = true;
				for(int i=1;i<num;i++) {
					now = list.get(i);
					weight += now.m;
					speed += now.s;
					if(isAllSame && isOdd != now.d%2)
						isAllSame = false;
				}
				weight = Math.floorDiv(weight, 5);
				if(weight == 0)
					continue;
				speed = Math.floorDiv(speed, num);
				isOdd = isAllSame ? 0 : 1;
				ArrayList<FireBall> tmp = new ArrayList<FireBall>();
				for(int d=isOdd;d<8;d+=2) 
					tmp.add(new FireBall(weight, speed, d));
				result.put(next.getKey(), tmp);
			} else
				result.put(next.getKey(), next.getValue());
		}
		return result;
	}
	private static HashMap<Integer, ArrayList<FireBall>> move() {
		HashMap<Integer, ArrayList<FireBall>> result = new HashMap<Integer, ArrayList<FireBall>>();
		Iterator<Entry<Integer, ArrayList<FireBall>>> iter = hMap.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, ArrayList<FireBall>> next = iter.next();
			int c = next.getKey()%N;
			int r = c==0 ? next.getKey()/N : next.getKey()/N+1;
			ArrayList<FireBall> balls = next.getValue();
			int size = balls.size();
			for(int i=0;i<size;i++) {
				FireBall now = balls.get(i);
				int nr = r + dr[now.d]*now.s;
				int nc = c + dc[now.d]*now.s;
				
				while(nr<0)
					nr += N;
				while(nc<0)
					nc += N;
				nr = nr%N==0 ? N : nr%N;
				nc = nc%N==0 ? N : nc%N;
				
				int num = (nr-1)*N + nc;
				
				if(!result.containsKey(num))
					result.put(num, new ArrayList<FireBall>());
				result.get(num).add(new FireBall(now.m, now.s, now.d));
			}
		}
		return result;
	}
}
