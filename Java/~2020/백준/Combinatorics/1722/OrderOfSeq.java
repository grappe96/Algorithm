/*
문제

1부터 N까지의 수를 임의로 배열한 순열은 총 N! = N×(N-1)×…×2×1 가지가 있다.
 임의의 순열은 정렬을 할 수 있다. 예를 들어  N=3인 경우 {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}의 순서로 생각할 수 있다. 
 첫 번째 수가 작은 것이 순서상에서 앞서며, 첫 번째 수가 같으면 두 번째 수가 작은 것이, 두 번째 수도 같으면 세 번째 수가 작은 것이….
N이 주어지면, 아래의 두 소문제 중에 하나를 풀어야 한다. 
k가 주어지면 k번째 순열을 구하고, 임의의 순열이 주어지면 이 순열이 몇 번째 순열인지를 출력하는 프로그램을 작성하시오.

입력

첫째 줄에 N(1≤N≤20)이 주어진다. 
둘째 줄의 첫 번째 수는 소문제 번호이다. 
 1인 경우 k(1≤k≤N!)를 입력받고, 2인 경우 임의의 순열을 나타내는 N개의 수를 입력받는다. 
N개의 수에는 1부터 N까지의 정수가 한 번씩만 나타난다.

출력

k번째 수열을 나타내는 N개의 수를 출력하거나, 몇 번째 수열인지를 출력하면 된다.
*/

import java.io.*;
import java.util.*;

public class OrderOfSeq {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        int[] chk = new int[21];
        long[] fac = new long[21];
        for(int i=0;i<=20;i++){
            if(i == 0 || i == 1)
                fac[i] = 1;
            else
                fac[i] = fac[i-1]*i;
        }
        if(q == 1){
            int[] ans = new int[N];
            long k = Long.parseLong(st.nextToken());
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(chk[j] == 1)
                        continue;
                    if(fac[N-i]<k)
                        k -= fac[N-i];
                    else{
                        ans[i-1] = j;
                        chk[j] = 1;
                        break;
                    }
                }
            }
            for(int i:ans)
                bw.write(i + " ");
            bw.write("\n");
        }else{
            long ans = 1;
            for(int i=1; i<=N; i++){
                int num = Integer.parseInt(st.nextToken());
                for(int j=1; j<num; j++)
                    if(chk[j] == 0)
                        ans += fac[N-i];
                chk[num] = 1;
            }
            bw.write(ans + "\n");
        }
        bw.close();
    }
}