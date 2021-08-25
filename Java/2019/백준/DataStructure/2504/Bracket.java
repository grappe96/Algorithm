/*
문제

4개의 기호 ‘(’, ‘)’, ‘[’, ‘]’를 이용해서 만들어지는 괄호열 중에서 올바른 괄호열이란 다음과 같이 정의된다.
 한 쌍의 괄호로만 이루어진 ‘()’와 ‘[]’는 올바른 괄호열이다. 
 만일 X가 올바른 괄호열이면 ‘(X)’이나 ‘[X]’도 모두 올바른 괄호열이 된다. 
 X와 Y 모두 올바른 괄호열이라면 이들을 결합한 XY도 올바른 괄호열이 된다.
예를 들어 ‘(()[[]])’나 ‘(())[][]’ 는 올바른 괄호열이지만 ‘([)]’ 나 ‘(()()[]’ 은 모두 올바른 괄호열이 아니다. 
우리는 어떤 올바른 괄호열 X에 대하여 그 괄호열의 값(괄호값)을 아래와 같이 정의하고 값(X)로 표시한다. 
 ‘()’ 인 괄호열의 값은 2이다.
 ‘[]’ 인 괄호열의 값은 3이다.
 ‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
 ‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
 올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.
예를 들어 ‘(()[[]])([])’ 의 괄호값을 구해보자.  
‘()[[]]’ 의 괄호값이 2 + 3×3=11 이므로  ‘(()[[ ]])’의 괄호값은 2×11=22 이다. 
그리고  ‘([])’의 값은 2×3=6 이므로 전체 괄호열의 값은 22 + 6 = 28 이다.
여러분이 풀어야 할 문제는 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력하는 것이다. 

입력

첫째 줄에 괄호열을 나타내는 문자열(스트링)이 주어진다. 
단 그 길이는 1 이상, 30 이하이다.

출력

첫째 줄에 그 괄호열의 값을 나타내는 정수를 출력한다. 
만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다. 
*/

import java.io.*;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] bracket = br.readLine().split("");
        Stack<String> calculate = new Stack<>();
        int res=0, square=0, round=0, wrong=0;

        for(int i=0; i<bracket.length; i++){
            if(wrong == 1)
                break;
            if(bracket[i].equals("(")){
                calculate.push(bracket[i]);
                round++;
            }else if(bracket[i].equals("[")){
                calculate.push(bracket[i]);
                square++;
            }else if(bracket[i].equals(")")){
                round--;
                if(round >= 0){
                    if(calculate.peek().equals("(")){
                        calculate.pop();
                        calculate.push("2");
                    }else{
                        int n=0;
                        while(!calculate.isEmpty()){
                            String s = calculate.peek();
                            if(s.equals("[")){
                                wrong = 1;
                                break;
                            }else if(!s.equals("("))
                                n += Integer.parseInt(calculate.pop());
                            else{
                                calculate.pop();
                                n *= 2;
                                calculate.push(Integer.toString(n));
                                break;
                            }
                        }
                    }
                }
            }else{
                square--;
                if(square >= 0){
                    if(calculate.peek().equals("[")){
                        calculate.pop();
                        calculate.push("3");
                    }else{
                        int n=0;
                        while(!calculate.isEmpty()){
                            String s = calculate.peek();
                            if(s.equals("(")){
                                wrong = 1;
                                break;
                            }else if(!s.equals("["))
                                n += Integer.parseInt(calculate.pop());
                            else{
                                calculate.pop();
                                n *= 3;
                                calculate.push(Integer.toString(n));
                                break;
                            }
                        }
                    }
                }
            }
            if(square < 0 || round < 0)
                wrong = 1;
        }
        if(square != 0 || round != 0)
            wrong = 1;
        if(wrong == 1)
            bw.write("0\n");
        else{
            while(!calculate.isEmpty())
                res += Integer.parseInt(calculate.pop());
            bw.write(res + "\n");
        }
        bw.close();
    }
}