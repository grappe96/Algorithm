/*
문제

N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 
이 수열의 i번째 수부터 j번째 수까지의 합 A[i]+A[i+1]+…+A[j-1]+A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

입력

첫째 줄에 N(1≤N≤10,000), M(1≤M≤300,000,000)이 주어진다. 
다음 줄에는 A[1], A[2], …, A[N]이 공백으로 분리되어 주어진다. 
각각의 A[x]는 30,000을 넘지 않는 자연수이다.

출력

첫째 줄에 경우의 수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class SumOfNum {
    public static void main(String[] args) throws IOException {

        //System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int front = 0, rear = 0, sum = 0, count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        while(true){
            if(sum == M)
                count++;
            if(rear == N)
                break;
            if(sum < M && front < N)
                sum += A[front++];
            else
                sum -= A[rear++];
        }
        bw.write(count + "\n");
        bw.close();
    }
}