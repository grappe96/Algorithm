/*
문제

N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력

첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력

첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class NQueen {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> Bt = new Stack<>();
        Stack<Integer> col = new Stack<>();
        Stack<Integer> slash = new Stack<>();
        Stack<Integer> bslash = new Stack<>();
        int r, c, chk, cnt=0, tmp;

        for(int i=N; i>0; i--){
            Bt.push(i);
            Bt.push(1);
        }
        r = Bt.pop();
        while(!Bt.empty()){
            c = Bt.pop();
            col.push(c);
            slash.push(r+c);
            bslash.push(r-c);
            chk = 0;

            for(int i=N; i>0; i--){
                if(col.contains(i) || i == c-1 || i == c+1 || slash.contains(r+1+i) || bslash.contains(r+1-i)){
                    chk++;
                }else if(r == N-1){
                    cnt++;
                }else{
                    Bt.push(i);
                    Bt.push(r+1);
                }
            }
            if(!Bt.empty()){
                tmp = r;
                r = Bt.pop();
                if (chk == N || tmp == N-1){
                    for(int j=tmp+1; j>r; j--){
                        col.pop();
                        slash.pop();
                        bslash.pop();
                    }
                }
            }
        }
        if(N == 1)
            cnt = 1;
        bw.write(cnt + "\n");
        bw.close();
    }
}