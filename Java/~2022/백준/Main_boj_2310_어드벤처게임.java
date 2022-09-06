package week8;

import java.io.*;
import java.util.*;

public class Main_boj_2310_어드벤처게임 {
	static class Room {
		char type;
		int cost, num;
		int[] rooms;
		public Room(char type, int cost, int num, int[] rooms) {
			this.type = type;
			this.cost = cost;
			this.num = num;
			this.rooms = rooms;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			// 미로 정보 저장
			Room[] maze = new Room[n+1];
			for(int i=1;i<=n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = st.countTokens()-3;
				char type = st.nextToken().charAt(0);
				int cost = Integer.parseInt(st.nextToken());
				int[] rooms = new int[num];
				for(int j=0;j<num;j++)
					rooms[j] = Integer.parseInt(st.nextToken());
				maze[i] = new Room(type, cost, num, rooms);
			}
			// 출구 탐색
			boolean[][] visited = new boolean[n+1][501];
			Queue<int[]> queue = new LinkedList<int[]>();
			
			visited[1][0] = true;
			queue.offer(new int[] {1, 0});
			boolean exit = false;
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				Room room = maze[now[0]];
				
				if(room.type == 'L') {
					if(now[1] < room.cost)
						now[1] = room.cost;
				} else if(room.type == 'T') {
					if(now[1] < room.cost)
						continue;
					else
						now[1] -= room.cost;
				}
				
				if(now[0] == n) {
					exit = true;
					break;
				}
					
				for(int i=0;i<room.num;i++) {
					int no = room.rooms[i];
					if(!visited[no][now[1]]) {
						visited[no][now[1]] = true;
						queue.offer(new int[] {no, now[1]});
					}
				}
			}
			if(exit)
				sb.append("Yes\n");
			else
				sb.append("No\n");
			
			n = Integer.parseInt(br.readLine().trim());
		}
		System.out.print(sb.toString());
	}
}
