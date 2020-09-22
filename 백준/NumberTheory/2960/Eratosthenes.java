/*
문제

에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.
이 알고리즘은 다음과 같다.
 2부터 N까지 모든 정수를 적는다.
 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
 P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.

입력

첫째 줄에 N과 K가 주어진다. (1 ≤ K < N, max(2, K) < N ≤ 1000)

출력

첫째 줄에 K번째 지워진 수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Eratosthenes {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[N+1];

        prime[1] = true;
        for(int i=2; i<=N; i++){
            for(int j=1; i*j<=N; j++){
                if(!prime[i*j]){
                    prime[i*j] = true;
                    if(--K == 0)
                        bw.write(i*j + "\n");
                }
            }
        }
        bw.close();
    }
}