/*
문제

이진 검색 트리는 다음과 같은 세 가지 조건을 만족하는 이진 트리이다.
 노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 작다.
 노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 크다.
 왼쪽, 오른쪽 서브트리도 이진 검색 트리이다.
 전위 순회 (루트-왼쪽-오른쪽)은 루트를 방문하고, 왼쪽 서브트리, 오른쪽 서브 트리를 순서대로 방문하면서 노드의 키를 출력한다. 
 후위 순회 (왼쪽-오른쪽-루트)는 왼쪽 서브트리, 오른쪽 서브트리, 루트 노드 순서대로 키를 출력한다. 
이진 검색 트리를 전위 순회한 결과가 주어졌을 때, 이 트리를 후위 순회한 결과를 구하는 프로그램을 작성하시오.

입력

트리를 전위 순회한 결과가 주어진다. 
노드에 들어있는 키의 값은 10^6보다 작은 양의 정수이다. 
모든 값은 한 줄에 하나씩 주어지며, 노드의 수는 10,000개 이하이다. 같은 키를 가지는 노드는 없다.

출력

입력으로 주어진 이진 검색 트리를 후위 순회한 결과를 한 줄에 하나씩 출력한다.
*/

import java.io.*;

class Node{
    int data;
    Node left;
    Node right;

    public Node(){
        this.left = null;
        this.right = null;
    }
    public Node(int d){
        this.data = d;
        this.left = null;
        this.right = null;
    }
}
class Tree{
    Node root = null;
    public Node insert(int data){
        Node node = new Node(data);
        if(root == null)
            root = node;
        else{
            Node next = root;
            int n = root.data;
            while(next != null){
                if(n > data)
                    if(next.left != null){
                        next = next.left;
                        n = next.data;
                    }else{
                        next.left = node;
                        break;
                    }
                else
                    if(next.right != null){
                        next = next.right;
                        n = next.data;
                    }else{
                        next.right = node;
                        break;
                    }
            }
        }
        return root;
    }
}
public class BST {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Tree t = new Tree();
        while(s != null){
            int num = Integer.parseInt(s);
            t.insert(num);
            s = br.readLine();
        }
        post(t.root);
    }
    public static void post(Node n){
        if(n != null){
            post(n.left);
            post(n.right);
            System.out.println(n.data);
        }
    }
}