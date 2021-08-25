package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_19238_��ŸƮ�ý� {
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
		
		taxi = new int[2]; // �ý� ��ġ
		st = new StringTokenizer(br.readLine());
		taxi[0] = Integer.parseInt(st.nextToken());
		taxi[1] = Integer.parseInt(st.nextToken());
		
		customer = new int[M+1][4]; // �մ� �����, ������
		cNum = M; // �������� �������� ���� �մ� ��
		for(int i=1;i<=cNum;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++)
				customer[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(fuel > 0) { // ���ᰡ �����ִ� ����
			// �����ִ� �մ� ����ŭ ���� �ý� ��ġ�� ���� ���� ����� �մ� ã��
			int now = 0, min = Integer.MAX_VALUE;
			for(int i=1;i<=cNum;i++) {
				int result = bfs(taxi[0], taxi[1], customer[i][0], customer[i][1]);
				
				if(result < 0)
					continue;
				if(min > result) {
					min = result;
					now = i;
				} else if (min == result) {
					// �Ÿ��� ������ ���ȣ ���� �մ�, ���ȣ�� ������ ����ȣ ���� �մ�
					if(customer[i][0] < customer[now][0] || (customer[i][0] == customer[now][0] && customer[i][1] < customer[now][1]))
						now = i;
				}
			}
			
			// �� �� �ִ� �մ��� ������
			if(now == 0) {
				fuel = -1;
				break;
			}
			fuel -= min; // �մԿ��� �̵��ϴµ� �� ���� ����

			// ���������� �ִ� �Ÿ�
			int cost = bfs(customer[now][0], customer[now][1], customer[now][2], customer[now][3]);
			// �� �� ���ٸ�
			if(cost < 0) {
				fuel = -1;
				break;
			}
			
			fuel -= cost; // ���������� ���µ� �� ���� ����
			if(fuel < 0) { // ���� ���߿� ���ᰡ �������ٸ�
				fuel = -1;
				break;
			}
			
			fuel += cost*2; // ���� ����
			// �ý� ��ġ <= �մ� ������
			taxi[0] = customer[now][2];
			taxi[1] = customer[now][3];
			
			// ���� �մ� �� ������ �ε����� �̵��� �մ� �ű��
			for(int i=0;i<4;i++)
				customer[now][i] = customer[cNum][i];
			
			// ��� �մ��� �̵������� break
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
