/*
문제

수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

입력

첫째 줄에 수의 개수 N (1 ≤ N ≤ 100,000), 합을 구해야 하는 횟수 M (1 ≤ M ≤ 100,000)이 주어진다. 
둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 
셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

출력

총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
*/

import java.io.*;
import java.util.*;

public class SumOfSection {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] num = new int[N+1];
        int[] sum = new int[N+1];
        int s1, s2;
        for (int i=1; i<=N; i++){
            num[i] = sc.nextInt();
            sum[i] = num[i] + sum[i-1];
        }
        for (int i=0; i<M; i++){
            s1 = sc.nextInt();
            s2 = sc.nextInt();
            bw.write(sum[s2] - sum[s1-1] + "\n");
        }
        sc.close();
        bw.flush();
        bw.close();
    }
}