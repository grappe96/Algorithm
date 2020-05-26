/*
문제

2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력

첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 
좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력

첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Tuple {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int[][] tuple = new int[N][2];
        String[] s = new String[2];
        for (int i=0; i<N; i++) {
            s = bf.readLine().split(" ");
            tuple[i][0] = Integer.parseInt(s[0]);
            tuple[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(tuple, new Comparator<int[]>() {
            @Override
            public int compare(int[] n1, int[] n2) {
                if (n1[0] == n2[0])
                    return n1[1] - n2[1];
                else
                    return n1[0] - n2[0];
            }
        });
        for (int i=0; i<N; i++)
            bw.write(tuple[i][0] + " " + tuple[i][1] + "\n");
        bw.flush();
        bw.close();
    }
}