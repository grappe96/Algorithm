package Practice.LINE2019;

/*
문제

연인 코니와 브라운은 광활한 들판에서 ‘나 잡아 봐라’ 게임을 한다. 
이 게임은 브라운이 코니를 잡거나, 코니가 너무 멀리 달아나면 끝난다. 
게임이 끝나는데 걸리는 최소 시간을 구하시오.

조건
 코니는 처음 위치 C에서 1초 후 1만큼 움직이고, 이후에는 가속이 붙어 매 초마다 이전 이동 거리 + 1만큼 움직인다. 
 즉 시간에 따른 코니의 위치는 C, C + 1, C + 3, C + 6, …이다.
 브라운은 현재 위치 B에서 다음 순간 B – 1, B + 1, 2 * B 중 하나로 움직일 수 있다.
 코니와 브라운의 위치 p는 조건 0 <= x <= 200,000을 만족한다.
 브라운은 범위를 벗어나는 위치로는 이동할 수 없고, 코니가 범위를 벗어나면 게임이 끝난다.

입력 형식

표준 입력의 첫 줄에 코니의 위치 C와 브라운의 위치 B를 공백으로 구분하여 순서대로 읽는다.

출력 형식

브라운이 코니를 잡을 수 있는 최소시간 N초를 표준 출력한다. 단 브라운이 코니를 잡지 못한 경우에는 -1을 출력한다.

출처 : https://engineering.linecorp.com/ko/blog/2019-firsthalf-line-internship-recruit-coding-test/
*/

import java.io.*;
import java.util.*;

class Pair {
    int BPosition;
    int time;

    Pair(int b, int t) {
        this.BPosition = b;
        this.time = t;
    }
}

public class CatchMeIfUCan {
    public static void main(String[] args) throws IOException {
        
        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N=0;
        boolean[][] visited = new boolean[200001][2]; //시간을 홀수 짝수로 나누어 저장, t초에 위치가 P일 경우 t+2초에 다시 P 위치 가능
        LinkedList<Pair> queue = new LinkedList<>();

        queue.add(new Pair(B, N));
        while(true){
            C += N;

            if(C > 200000){
                N = -1;
                break;
            }
            if(visited[C][N%2]) // C 위치에 도달했는지 확인
                break;

            for(int i=0,size=queue.size();i<size;i++){ // 다음 초에 갈 수 있는 모든 위치 체크
                Pair next = queue.poll();
                int currentP = next.BPosition;
                int newTime = (next.time+1)%2;
                int newBP;

                newBP = currentP-1;
                if(newBP>=0 && !visited[newBP][newTime]){
                    visited[newBP][newTime] = true;
                    queue.add(new Pair(newBP, newTime));
                }
                newBP = currentP+1;
                if(newBP<=200000 && !visited[newBP][newTime]){
                    visited[newBP][newTime] = true;
                    queue.add(new Pair(newBP, newTime));
                }
                newBP = currentP*2;
                if(newBP<=200000 && !visited[newBP][newTime]){
                    visited[newBP][newTime] = true;
                    queue.add(new Pair(newBP, newTime));
                }
            }
            N++;
        }
        bw.write(N + "\n");
        bw.close();
    }
}