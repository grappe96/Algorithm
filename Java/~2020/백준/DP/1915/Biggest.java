/*
문제

n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램을 작성하시오.
 0	 1	 0	 0
 0	 1	 1	 1
 1	 1	 1	 0
 0	 0	 1	 0
위와 같은 예제에서는 가운데의 2×2 배열이 가장 큰 정사각형이다. 

입력

첫째 줄에 n, m(1 ≤ n, m ≤ 1,000)이 주어진다. 
다음 n개의 줄에는 m개의 숫자로 배열이 주어진다.

출력

첫째 줄에 가장 큰 정사각형의 넓이를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Biggest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][M+1];
        int side = 0;
        for (int i=0; i<N; i++){
            char[] line = br.readLine().toCharArray();
            for (int j=0; j<M; j++){
                dp[i+1][j+1] = line[j] - '0';
                if(dp[i+1][j+1] == 1){
                    dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]))+1;
                    side = Math.max(dp[i+1][j+1], side);
                }
            }
        }
        System.out.println(side*side);
    }
}