/*
문제

트리는 굉장히 잘 알려진 자료 구조이다. 
트리를 만족하는 자료 구조는 비어 있거나(노드의 개수가 0개), 노드의 개수가 1개 이상이고 방향 간선이 존재하며 다음과 같은 조건을 만족해야 한다. 
이때, 노드 u에서 노드 v로 가는 간선이 존재하면 간선을 u에 대해서는 '나가는 간선', v에 대해서는 '들어오는 간선'이라고 하자.
 들어오는 간선이 하나도 없는 단 하나의 노드가 존재한다. 이를 루트(root) 노드라고 부른다.
 루트 노드를 제외한 모든 노드는 반드시 단 하나의 들어오는 간선이 존재한다.
 루트에서 다른 노드로 가는 경로는 반드시 가능하며, 유일하다. 이는 루트를 제외한 모든 노드에 성립해야 한다.
당신은 간선의 정보들을 받아서 해당 케이스가 트리인지를 판별해야 한다.

입력

입력은 여러 개의 테스트 케이스로 이루어져 있으며, 입력의 끝에는 두 개의 음의 정수가 주어진다.
각 테스트 케이스는 여러 개의 정수쌍으로 이루어져 있으며, 테스트 케이스의 끝에는 두 개의 0이 주어진다.
각 정수쌍 u, v에 대해서 이는 노드 u에서 노드 v로 가는 간선이 존재함을 의미한다. 
u와 v는 0보다 크다.

출력

각 테스트 케이스에 대해서, 테스트 케이스의 번호가 k일 때(k는 1부터 시작하며, 1씩 증가한다) 트리일 경우 "Case k is a tree."를, 트리가 아닐 경우 "Case k is not a tree."를 출력한다.

예제
6 8  5 3  5 2  6 4
5 6  0 0

8 1  7 3  6 2  8 9  7 5
7 4  7 8  7 6  0 0

3 8  6 8  6 4
5 3  5 6  5 2  0 0

0 0

1 2  0 0

1 2  2 1  0 0

1 1  0 0

1 2  2 3  3 1  4 5  0 0

1 2  2 3  3 1  0 0
-1 -1
*/

import java.io.*;
import java.util.*;

public class IsTree {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, String> map = new HashMap<>();
        int count = 1, istree = 1, o = 0, end = 0, I = 0;
        ArrayList<String> out = new ArrayList<>();
        ArrayList<String> in = new ArrayList<>();

        while(end == 0){
            String str = br.readLine();
            if(str != null){
                String[] s = str.replaceAll("  ", " ").split(" ");
                for(int i=1; i<s.length; i+=2){
                    if(s[i-1].equals("0")){
                        if(I > 1 && I <= o)
                            istree = 0;
                        if(istree == 1){
                            for(String tmp : out)
                                if(map.containsKey(tmp))
                                    o--;
                            if(o != 1)
                                istree = 0;
                            if(map.isEmpty() && o == 0)
                                istree = 1;
                        }
                        if(istree == 1)
                            bw.write("Case " + count++ + " is a tree.\n");
                        else if(istree == 0){
                            bw.write("Case " + count++ + " is not a tree.\n");
                            istree = 1;
                        }
                        out.clear();
                        in.clear();
                        map.clear();
                        o = 0;
                        I = 0;
                    }else if(!s[i-1].equals("") && Integer.parseInt(s[i-1])<0){
                        end = 1;
                        break;
                    }
                    else{
                        if(map.containsKey(s[i]))
                            istree = 0;
                        else{
                            map.put(s[i], s[i-1]);
                            if(!out.contains(s[i-1])){
                                out.add(s[i-1]);
                                o++;
                            }
                            if(!in.contains(s[i])){
                                in.add(s[i]);
                                I++;
                            }
                        }
                    }
                }
            }
        }
        bw.close();
    }
}