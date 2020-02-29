/*
문제

원룡이는 한 컴퓨터 보안 회사에서 일을 하고 있다. 
그러던 도중, 원룡이는 YESWOA.COM 으로부터 홈페이지 유저들의 비밀키를 만들라는 지시를 받았다. 
원룡이는 비밀 키를 다음과 같은 방법으로 만들었다.
개인마다 어떤 특정한 소수 p와 q를 주어 두 소수의 곱 pq를 비밀 키로 두었다. 
이렇게 해 주면 두 소수 p,q를 알지 못하는 이상, 비밀 키를 알 수 없다는 장점을 가지고 있다.
하지만 원룡이는 한 가지 사실을 잊고 말았다. 
최근 컴퓨터 기술이 발달함에 따라, 소수가 작은 경우에는 컴퓨터로 모든 경우의 수를 돌려보아 비밀 키를 쉽게 알 수 있다는 것이다.
원룡이는 주성조교님께 비밀 키를 제출하려던 바로 직전에 이 사실을 알아냈다. 
그래서 두 소수 p, q 중 하나라도 K보다 작은 암호는 좋지 않은 암호로 간주하여 제출하지 않기로 하였다. 
이것을 손으로 직접 구해보는 일은 매우 힘들 것이다. 
당신은 원룡이를 도와 두 소수의 곱으로 이루어진 암호와 K가 주어져 있을 때, 그 암호가 좋은 암호인지 좋지 않은 암호인지 구하는 프로그램을 작성하여야 한다.

입력

암호 P(4 ≤ P ≤ 10100)와 K (2 ≤ K ≤ 106) 이 주어진다.

출력

만약에 그 암호가 좋은 암호이면 첫째 줄에 GOOD을 출력하고, 만약에 좋지 않은 암호이면 BAD와 소수 r을 공백으로 구분하여 출력하는데 r은 암호를 이루는 두 소수 중 작은 소수를 의미한다.
*/

import java.io.*;
import java.util.*;

public class MakePW {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String P = st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[K];
        int find = 0;

        prime[1] = true;
        for(int i=2; i<K; i++){
            for(int j=2; i*j < K; j++){
                prime[i*j] = true;
            }
        }
        for(int i=2; i<K; i++){
            int mod = 0;
            if(!prime[i]){
                for(int j=0; j<P.length(); j++)
                    mod = (mod*10 + (P.charAt(j)-'0')) % i;
                if(mod == 0){
                    bw.write("BAD " + i + "\n");
                    find = 1;
                    break;
                }
            }
        }
        if(find == 0)
            bw.write("GOOD\n");
        bw.close();
    }
}