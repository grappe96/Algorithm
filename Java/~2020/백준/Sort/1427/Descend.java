/*
문제

배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

입력

첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력

첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
*/

import java.util.Scanner;

public class Descend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        int[] num = new int[s.length()];
        int tmp;
        for (int i=0; i<s.length(); i++)
            num[i] = s.charAt(i)-'0';
        for (int i=0; i<s.length(); i++){
            for (int j=i+1; j<s.length(); j++){
                if (num[i] < num[j]){
                    tmp = num[j];
                    num[j] = num[i];
                    num[i] = tmp;
                }
            }
        }
        for (int i=0; i<s.length();i++)
            System.out.print(num[i]);
        System.out.println();
    }
}