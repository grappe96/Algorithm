/*
문제

이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.

입력

첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다. 
둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 
노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 
자식 노드가 없는 경우에는 .으로 표현된다.

출력

첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 
각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
*/

import java.io.*;
import java.util.*;

public class TreeCircuit {
    public static HashMap<String, String> tree = new HashMap<String, String>();
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String s = br.readLine();
            s = s.replaceAll(" ", "");
            tree.put(s.substring(0, 1), s.substring(1));
        }
        pre(tree, "A"); System.out.println();
        in(tree, "A"); System.out.println();
        post(tree, "A"); System.out.println();
    }
    public static void pre(HashMap<String, String> t, String key) throws IOException {
        if(!key.equals(".")){
            System.out.print(key);
            pre(t, t.get(key).substring(0, 1));
            pre(t, t.get(key).substring(1));
        }
    }
    public static void in(HashMap<String, String> t, String key) throws IOException {
        if(!key.equals(".")){
            in(t, t.get(key).substring(0, 1));
            System.out.print(key);
            in(t, t.get(key).substring(1));
        }
    }
    public static void post(HashMap<String, String> t, String key) throws IOException {
        if(!key.equals(".")){
            post(t, t.get(key).substring(0, 1));
            post(t, t.get(key).substring(1));
            System.out.print(key);
        }
    }
}