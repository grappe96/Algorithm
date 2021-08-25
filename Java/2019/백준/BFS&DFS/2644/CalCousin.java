/*
문제

우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다. 
이러한 촌수는 다음과 같은 방식으로 계산된다. 
기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다. 
예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 
아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.

입력

사람들은 1, 2, 3, …, n (1≤n≤100)의 연속된 번호로 각각 표시된다. 
입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 
그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 
넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 
이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
각 사람의 부모는 최대 한 명만 주어진다.

출력

입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 
어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 
이때에는 -1을 출력해야 한다.
*/

import java.io.*;
import java.util.*;

public class CalCousin {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int other = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[p][c] = 1;
            map[c][p] = 1;
        }
        
        int[] cousin = new int[n+1];
        Queue<Integer> Queue = new LinkedList<Integer>();
        Queue.add(one);
        while(!Queue.isEmpty()){
            int next = Queue.poll();
            for(int i=1;i<=n;i++){
                if(map[next][i]==1 && cousin[i]==0){
                    Queue.add(i);
                    cousin[i] = cousin[next]+1;
                }
            }
            if(!Queue.isEmpty() && Queue.peek()==other)
                break;
        }
        if(cousin[other] == 0)
            bw.write("-1\n");
        else
            bw.write(cousin[other] + "\n");
        bw.close();
    }
}