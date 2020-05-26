/*

문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
연산을 사용하는 횟수의 최솟값을 출력하시오.

입력

첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력

첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
*/

import java.util.*;

public class MakeToOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
        int answer = make2one(N, dp);
        System.out.println(answer);
    }

    public static int make2one(int n, HashMap<Integer, Integer> dp){
        int value = 0;

        if (dp.containsKey(n))
            return dp.get(n);
        else { 
		if (n == 1)
            return 0;
        value = make2one(n-1, dp) + 1;
        if (n%3 == 0)
            value = Math.min(value, make2one(n/3, dp) + 1);
        else if (n%2 == 0)
            value = Math.min(value, make2one(n/2, dp) + 1);
        dp.put(n, value);
        }
        return value;
    }
}