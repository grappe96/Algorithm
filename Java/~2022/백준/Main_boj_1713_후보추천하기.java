package boj;

import java.io.*;
import java.util.*;

public class Main_boj_1713_후보추천하기 {
	static final int number = 100;
	static class Info implements Comparable<Info> {
		int no, like, time;
		public Info(int no, int like, int time) {
			this.no = no;
			this.like = like;
			this.time = time;
		}
		@Override
		public int compareTo(Info o) {
			if(this.like == o.like)
				return this.time - o.time;
			return this.like - o.like;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] check = new boolean[number+1];
        PriorityQueue<Info> info = new PriorityQueue<Info>();
        int size = 0;
        for(int i=0;i<R;i++) {
        	int now = Integer.parseInt(st.nextToken());
        	if(check[now]) {
        		for(Info I : info) {
        			if(I.no == now) {
        				info.add(new Info(now, I.like+1, I.time));
        				info.remove(I);
        				break;
        			}
        		}
        	}else {
        		check[now] = true;
        		if(size == N)
        			check[info.poll().no] = false;
        		else
        			size++;
        		info.add(new Info(now, 1, i));
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=number;i++)
        	if(check[i])
        		sb.append(i).append(" ");
        System.out.print(sb.toString());
    }
}
