/*
문제

사악한 암흑의 군주 이민혁은 드디어 마법 구슬을 손에 넣었고, 그 능력을 실험해보기 위해 근처의 티떱숲에 홍수를 일으키려고 한다. 
이 숲에는 고슴도치가 한 마리 살고 있다. 
고슴도치는 제일 친한 친구인 비버의 굴로 가능한 빨리 도망가 홍수를 피하려고 한다.
 티떱숲의 지도는 R행 C열로 이루어져 있다. 
 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.
 매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다. (위, 아래, 오른쪽, 왼쪽) 
 물도 매 분마다 비어있는 칸으로 확장한다. 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 
 물과 고슴도치는 돌을 통과할 수 없다. 또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.
티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.
 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 
 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 
 이동할 수 있으면 고슴도치가 물에 빠지기 때문이다. 

입력

첫째 줄에 50보다 작거나 같은 자연수 R과 C가 주어진다.
다음 R개 줄에는 티떱숲의 지도가 주어지며, 문제에서 설명한 문자만 주어진다. 'D'와 'S'는 하나씩만 주어진다.

출력

첫째 줄에 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간을 출력한다. 
만약, 안전하게 비버의 굴로 이동할 수 없다면, "KAKTUS"를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Escape {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int R = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        String[][] map = new String[R][C];
        int[][] visited = new int[R][C];
        ArrayList<int[]> water = new ArrayList<>();
        Queue<int[]> S = new LinkedList<int[]>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int x=0, y=0, size, one=0;
        int[] now, exit = new int[2];

        for(int i=0; i<R; i++){
            s = br.readLine().split("");
            for(int j=0; j<C; j++){
                map[i][j] = s[j];
                visited[i][j] = -1;
                if(map[i][j].equals("S")){
                    S.offer((new int[]{i,j}));
                    visited[i][j] += 1;
                }else if(map[i][j].equals("*")){
                    water.add(new int[]{i,j});
                }else if(map[i][j].equals("D")){
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        while(!S.isEmpty() && visited[exit[0]][exit[1]] == -1){
            now = S.poll();
            if(visited[now[0]][now[1]] == one){
                size = water.size();
                for(int i=0; i<size; i++){
                    for(int j=0; j<4; j++){
                        x = water.get(i)[0]+dx[j];
                        y = water.get(i)[1]+dy[j];
                        if(x < R && x >= 0 && y < C && y >= 0)
                            if(map[x][y].equals(".") && !water.contains(new int[]{x, y})){
                                water.add(new int[]{x, y});
                                map[x][y] = "*";
                            }
                    }
                }
                one+=1;
            }
            for(int i=0; i<4; i++){
                x = now[0] + dx[i];
                y = now[1] + dy[i];
                if(x < R && x >= 0 && y < C && y >= 0){
                    if(map[x][y].equals("D")){
                        S = new LinkedList<int[]>();
                        visited[x][y] = visited[now[0]][now[1]]+1;
                        break;
                    }else if(map[x][y].equals(".") && visited[x][y] == -1){
                        S.offer(new int[]{x, y});
                        visited[x][y] = visited[now[0]][now[1]]+1;
                    }
                }
            }
        }
        if(visited[exit[0]][exit[1]] == -1)
            bw.write("KAKTUS"+"\n");
        else
            bw.write(visited[exit[0]][exit[1]] + "\n");
        bw.close();
    }
}