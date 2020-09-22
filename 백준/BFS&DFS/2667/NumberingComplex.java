/*
문제
정사각형 모양의 지도가 있다. 
1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
대각선상에 집이 있는 경우는 연결된 것이 아니다. 
지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

입력

첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력

첫 번째 줄에는 총 단지수를 출력하시오. 
그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
*/

import java.io.*;
import java.util.*;

public class NumberingComplex {
    public static int N;
    public static int[][] map;
    public static int house;
    public static void main(String[] args) throws IOException {
        
        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            String[] s = br.readLine().split("");
            for(int j=1;j<=N;j++)
                map[i][j] = Integer.parseInt(s[j-1]);
        }
        ArrayList<Integer> num = new ArrayList<>();
        int count = 0;
        for(int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                if(map[i][j] == 1){
                    count++;
                    house = 0;
                    find(i, j);
                    num.add(house);
                }

        bw.write(count + "\n");
        Collections.sort(num);
        for(int i : num)
            bw.write(i + "\n");
        bw.close();
    }
    public static void find(int a, int b){
        map[a][b] = 0;
        house++;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i=0;i<4;i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if(x>0 && y>0 && x<=N && y<=N && map[x][y]==1)
                find(x, y);
        }
    }
}