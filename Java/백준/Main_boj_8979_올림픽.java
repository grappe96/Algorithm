package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_8979_¿Ã¸²ÇÈ {
	static class Country implements Comparable<Country>{
		int num, gold, silver, bronze;
		
		public Country(int num, int gold, int silver, int bronze) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
		@Override
		public int compareTo(Country o) {
			if(this.gold == o.gold) {
				if(this.silver == o.silver)
					return o.bronze - this.bronze;
				else
					return o.silver - this.silver;
			}
			return o.gold - this.gold;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Country[] list = new Country[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(list);
		Country before = list[0];
		if(before.num == K)
			System.out.println(1);
		else {
			int rank = 1, same = 0;
			for(int i=1;i<N;i++) {
				Country now = list[i];
				if(now.gold == before.gold && now.silver == before.silver && now.bronze == before.bronze)
					same++;
				else if(same == 0)
					rank++;
				else {
					rank += same+1;
					same = 0;
				}
				
				if(now.num == K)
					break;
				before = now;
			}
			System.out.println(rank);
		}
	}
}
