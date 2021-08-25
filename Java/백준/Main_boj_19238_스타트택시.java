package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_19238_스타트택시 {
	static int N, M, fuel, cNum, dr[] = {1,-1,0,0}, dc[]= {0,0,-1,1}, map[][], taxi[], customer[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		taxi = new int[2]; // 택시 위치
		st = new StringTokenizer(br.readLine());
		taxi[0] = Integer.parseInt(st.nextToken());
		taxi[1] = Integer.parseInt(st.nextToken());
		
		customer = new int[M+1][4]; // 손님 출발지, 목적지
		cNum = M; // 목적지에 도착하지 않은 손님 수
		for(int i=1;i<=cNum;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++)
				customer[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(fuel > 0) { // 연료가 남아있는 동안
			// 남아있는 손님 수만큼 현재 택시 위치와 비교해 가장 가까운 손님 찾기
			int now = 0, min = Integer.MAX_VALUE;
			for(int i=1;i<=cNum;i++) {
				int result = bfs(taxi[0], taxi[1], customer[i][0], customer[i][1]);
				
				if(result < 0)
					continue;
				if(min > result) {
					min = result;
					now = i;
				} else if (min == result) {
					// 거리가 같으면 행번호 작은 손님, 행번호도 같으면 열번호 작은 손님
					if(customer[i][0] < customer[now][0] || (customer[i][0] == customer[now][0] && customer[i][1] < customer[now][1]))
						now = i;
				}
			}
			
			// 갈 수 있는 손님이 없으면
			if(now == 0) {
				fuel = -1;
				break;
			}
			fuel -= min; // 손님에게 이동하는데 든 연료 감소

			// 목적지까지 최단 거리
			int cost = bfs(customer[now][0], customer[now][1], customer[now][2], customer[now][3]);
			// 갈 수 없다면
			if(cost < 0) {
				fuel = -1;
				break;
			}
			
			fuel -= cost; // 목적지까지 가는데 든 연료 감소
			if(fuel < 0) { // 가는 도중에 연료가 떨어진다면
				fuel = -1;
				break;
			}
			
			fuel += cost*2; // 연료 충전
			// 택시 위치 <= 손님 목적지
			taxi[0] = customer[now][2];
			taxi[1] = customer[now][3];
			
			// 남은 손님 중 마지막 인덱스로 이동한 손님 옮기기
			for(int i=0;i<4;i++)
				customer[now][i] = customer[cNum][i];
			
			// 모든 손님이 이동했으면 break
			if(--cNum == 0)
				break;
		}
		System.out.println(fuel);
	}
	private static int bfs(int i, int j, int k, int l) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N+1][N+1];
		int distance = -1;
		
		queue.offer(new int[] {i, j, 0});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(now[0] == k && now[1] == l) {
				distance = now[2];
				break;
			}
			
			for(int d=0;d<4;d++) {
				int nr = now[0]+dr[d];
				int nc = now[1]+dc[d];
				
				if(nr<=0||nc<=0||nr>N||nc>N||visited[nr][nc]||map[nr][nc]==1)
					continue;
				
				queue.offer(new int[] {nr, nc, now[2]+1});
				visited[nr][nc] = true;
			}
		}
		
		return distance;
	}
}
