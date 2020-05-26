/*
문제

초기에 {0}, {1}, {2}, ... {n} 이 각각 n+1개의 집합을 이루고 있다. 
여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
집합을 표현하는 프로그램을 작성하시오.

입력

첫째 줄에 n(1≤n≤1,000,000), m(1≤m≤100,000)이 주어진다. 
m은 입력으로 주어지는 연산의 개수이다. 
다음 m개의 줄에는 각각의 연산이 주어진다. 
합집합은 0 a b의 형태로 입력이 주어진다. 
이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다. 
두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다. 
이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다. 
a와 b는 n 이하의 자연수또는 0이며 같을 수도 있다.

출력

1로 시작하는 입력에 대해서 한 줄에 하나씩 YES/NO로 결과를 출력한다. (yes/no 를 출력해도 된다)
*/
import java.io.*;
import java.util.*;

public class ExpOfSet {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] S = new int[n+1];

        for(int i=0;i<=n;i++)
            S[i] = i;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(u == 0)
                union(S, n1, n2);
            else if(u == 1){
                if(find(S, n1) == find(S, n2))
                    bw.write("YES\n");
                else
                    bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static int find(int[] s, int n){
        if(s[n] == n)
            return n;
        int p = find(s, s[n]);
        return p;
    }
    public static void union(int[] s, int n1, int n2){
        n1 = find(s, n1);
        n2 = find(s, n2);
        if(n1 < n2)
            s[n2] = n1;
        else
            s[n1] = n2;
    }
}