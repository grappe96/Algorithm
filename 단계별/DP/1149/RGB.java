/*
문제

RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 
또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 
집 i의 이웃은 집 i-1과 집 i+1이고, 첫 집과 마지막 집은 이웃이 아니다.
각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 모든 집을 칠하는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력

첫째 줄에 집의 수 N이 주어진다. 
N은 1,000보다 작거나 같다. 
둘째 줄부터 N개의 줄에 각 집을 빨강으로, 초록으로, 파랑으로 칠하는 비용이 주어진다. 비용은 1,000보다 작거나 같은 자연수이다.

출력

첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
*/

import java.io.*;

public class RGB {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        int[][] rgb = new int[T][3];
        String[] tmp;
        for (int i = 0; i<T; i++) {
            tmp = bf.readLine().split(" ");
            rgb[i][0] = Integer.parseInt(tmp[0]);
            rgb[i][1] = Integer.parseInt(tmp[1]);
            rgb[i][2] = Integer.parseInt(tmp[2]);
        }
        for (int i=1; i<T; i++){
            rgb[i][0] += Math.min(rgb[i-1][1], rgb[i-1][2]);
            rgb[i][1] += Math.min(rgb[i-1][0], rgb[i-1][2]);
            rgb[i][2] += Math.min(rgb[i-1][0], rgb[i-1][1]);
        }
        bw.write(Math.min(rgb[T-1][0], Math.min(rgb[T-1][1], rgb[T-1][2])) + "\n");
        bw.flush();
        bw.close();
    }
}