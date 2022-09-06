package programmers;

public class Solution_pg_신규아이디추천 {

	public static void main(String[] args) {
		System.out.println(solution("abcdefghijklmn.p"));
	}
	public static String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^\\w-.]*", "");
        answer = answer.replaceAll("\\.{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$","");
        if(answer.length() == 0)
        	answer = "a";
        if(answer.length() > 15) {
        	answer = answer.substring(0, 15);
        	answer = answer.replaceAll("[.]$", "");
        }
        while(answer.length() < 3)
        	answer = answer.concat(answer.substring(answer.length()-1));
        return answer;
    }

}
